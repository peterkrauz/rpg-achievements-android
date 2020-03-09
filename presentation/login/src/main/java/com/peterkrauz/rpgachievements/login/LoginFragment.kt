package com.peterkrauz.rpgachievements.login

import androidx.core.view.isVisible
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.extensions.snackBar
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : StatefulFragment<LoginViewState>(R.layout.fragment_login) {

    private val loginRouter by inject<LoginRouter>()

    override val viewModel by inject<LoginViewModel>()

    override fun setupView() {
        buttonLogin.setOnClickListener { doLogin() }
    }

    private fun doLogin() {
        val username = textInputUsername.editText?.text.toString()
        val password = textInputPassword.editText?.text.toString()
        viewModel.login(username, password)
    }

    override fun setViewState(viewState: LoginViewState) {
        progressBarLoading.isVisible = viewState == LoginViewState.Loading
        enableInputViews(viewState != LoginViewState.Loading)

        when (viewState) {
            is LoginViewState.Success -> proceedToHome(viewState.authToken)
            is LoginViewState.Failure -> snackBar(loginRootLayout, "Unable to login")
        }
    }

    private fun enableInputViews(enabledViews: Boolean) {
        textInputUsername.isEnabled = enabledViews
        textInputPassword.isEnabled = enabledViews
        buttonLogin.isEnabled = enabledViews
    }

    private fun proceedToHome(authToken: AuthorizationToken) {
        viewModel.proceedToHome(authToken)
        loginRouter.navigateFromLoginToHome()
    }
}
