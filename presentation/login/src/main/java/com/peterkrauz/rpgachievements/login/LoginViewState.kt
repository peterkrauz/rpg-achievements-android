package com.peterkrauz.rpgachievements.login

import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.presentation.common_ui.base.BaseViewState

sealed class LoginViewState : BaseViewState {
    object Loading : LoginViewState()
    data class Failure(val error: Throwable) : LoginViewState()
    data class Success(val authToken: AuthorizationToken) : LoginViewState()
}
