package com.peterkrauz.rpgachievements.navigation

import com.peterkrauz.presentation.common_ui.LoginRouter
import com.peterkrauz.rpgachievements.R

object Navigator : BaseNavigator(), LoginRouter {

    override fun navigateFromSplashToLogin() {
        navController?.navigate(R.id.action_splash_to_login)
    }
}
