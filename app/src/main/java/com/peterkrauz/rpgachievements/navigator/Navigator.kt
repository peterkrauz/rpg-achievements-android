package com.peterkrauz.rpgachievements.navigator

import android.os.Bundle
import com.peterkrauz.presentation.common_ui.routers.HomeRouter
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.R

object Navigator : BaseNavigator(), LoginRouter, HomeRouter {

    override fun navigateFromSplashToLogin() {
        navController?.navigate(R.id.action_splash_to_login)
    }

    override fun navigateFromLoginToHome() {
        navController?.navigate(R.id.action_login_to_home)
    }

    override fun navigateFromSplashToHome() {
        navController?.navigate(R.id.action_splash_to_home)
    }

    override fun navigateFromHomeToAchievements(rpgExtra: Bundle) {
        navController?.navigate(R.id.action_home_to_achievements, rpgExtra)
    }
}
