package com.peterkrauz.rpgachievements.login

import androidx.lifecycle.viewModelScope
import com.peterkrauz.common.EspressoIdlingResource
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(private val loginUseCase: LoginUseCase) : StatefulViewModel<LoginViewState>() {

    fun login(username: String, password: String) {
        EspressoIdlingResource.increment()

        postValue(LoginViewState.Loading)
        viewModelScope.launch(baseErrorHandler) {
            val authToken = loginUseCase.login(username, password)
            postValue(LoginViewState.Success(authToken))
        }

        EspressoIdlingResource.decrement()
    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        postValue(LoginViewState.Failure(error))
    }

    fun proceedToHome(authToken: AuthorizationToken) {

    }
}
