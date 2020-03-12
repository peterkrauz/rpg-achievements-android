package com.peterkrauz.rpgachievements.login

import androidx.core.view.isVisible
import androidx.lifecycle.observe
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.extensions.snackBar
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginFragment : StatefulFragment<LoginViewState>(R.layout.fragment_login) {

    override val viewModel by inject<LoginViewModel> {
        parametersOf(context)
    }

    override fun setupView() {
        buttonLogin.setOnClickListener { doLogin() }
        textInputUsername.setOnClickListener { cancelErrors() }
        textInputPassword.setOnClickListener { cancelErrors() }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.fieldErrorsLiveEvent.observe(this) { setFieldErrors() }
    }

    private fun doLogin() {
        cancelErrors()
        val username = textInputUsername.editText?.text.toString()
        val password = textInputPassword.editText?.text.toString()
        viewModel.login(username, password)
    }

    private fun cancelErrors() {
        textInputUsername.error = null
        textInputPassword.error = null
    }

    override fun setViewState(viewState: LoginViewState) {
        progressBarLoading.isVisible = viewState == LoginViewState.Loading
        enableInputViews(viewState != LoginViewState.Loading)

        when (viewState) {
            is LoginViewState.Success -> proceedToHome(viewState.authToken)
            is LoginViewState.Failure -> snackBar(loginRootLayout, "Unable to login")
        }
    }

    private fun setFieldErrors() {
        textInputUsername.error = "Did you type your username correctly?"
        textInputPassword.error = "Did you type your password correctly?"
    }

    private fun enableInputViews(enabledViews: Boolean) {
        textInputUsername.isEnabled = enabledViews
        textInputPassword.isEnabled = enabledViews
        buttonLogin.isEnabled = enabledViews
        buttonLogin.isClickable = enabledViews
    }

    private fun proceedToHome(authToken: AuthorizationToken) {
        viewModel.proceedToHome(authToken)
    }
}
