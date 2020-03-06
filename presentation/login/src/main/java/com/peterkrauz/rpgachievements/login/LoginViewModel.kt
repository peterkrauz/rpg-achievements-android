package com.peterkrauz.rpgachievements.login

import com.peterkrauz.common.EspressoIdlingResource
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.presentation.common_ui.base.BaseViewModel

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    fun login(email: String, password: String) {
        EspressoIdlingResource.increment()



        EspressoIdlingResource.decrement()
    }
}
