package com.peterkrauz.rpgachievements.login

import androidx.core.view.isVisible
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.extensions.snackBar
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : StatefulFragment<LoginViewState>(R.layout.fragment_login) {

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

        when (viewState) {
            is LoginViewState.Success -> viewModel.proceedToHome(viewState.authToken)
            is LoginViewState.Failure -> snackBar(loginRootLayout, "Unable to login")
        }
    }
}
