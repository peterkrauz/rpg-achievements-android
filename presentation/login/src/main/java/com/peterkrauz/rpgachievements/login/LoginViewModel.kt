package com.peterkrauz.rpgachievements.login

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.peterkrauz.common.EspressoIdlingResource
import com.peterkrauz.common.SingleLiveEvent
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import kotlinx.coroutines.launch
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import kotlin.coroutines.CoroutineContext

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    appContext: Context
) : StatefulViewModel<LoginViewState>() {

    private val loginRouter by inject<LoginRouter>()

    private val sessionStore by inject<SessionStore> {
        parametersOf(appContext)
    }

    val fieldErrorsLiveEvent = SingleLiveEvent<Unit>()

    fun login(username: String, password: String) {
        EspressoIdlingResource.increment()

        if (username.isBlank() || password.isBlank()) {
            fieldErrorsLiveEvent.call()
            return
        }

        putValue(LoginViewState.Loading)
        performLogin(username, password)

        EspressoIdlingResource.decrement()
    }

    private fun performLogin(username: String, password: String) {
        viewModelScope.launch(baseErrorHandler) {
            val authToken = loginUseCase.login(username, password)
            putValue(LoginViewState.Success(authToken))
        }
    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        putValue(LoginViewState.Failure(error))
    }

    fun proceedToHome(authToken: AuthorizationToken) {
        sessionStore.cacheToken(authToken)
        loginRouter.navigateFromLoginToHome()
    }
}
