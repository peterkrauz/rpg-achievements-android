package com.peterkrauz.rpgachievements.navhosts

import androidx.navigation.fragment.findNavController
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.di.components.LoginComponent
import com.peterkrauz.rpgachievements.login.splash.SplashScreenListener
import com.peterkrauz.rpgachievements.navhosts.base.BaseActivity
import com.peterkrauz.rpgachievements.navigator.Navigator
import kotlinx.android.synthetic.main.activity_landing.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LandingActivity : BaseActivity(R.layout.activity_landing), SplashScreenListener {

    override val modules = LoginComponent.modules()

    private val loginRouter by inject<LoginRouter>()

    private val sessionStore by inject<SessionStore> {
        parametersOf(applicationContext)
    }

    override fun doPreCreation() {
        setTheme(R.style.RpgAchievements)
    }

    override fun onResume() {
        super.onResume()
        Navigator.bind(navHostFragment.findNavController())
    }

    override fun onAnimationsEnd() {
        if (sessionStore.hasSession()) {
            loginRouter.navigateFromSplashToHome()
            finish()
        } else {
            loginRouter.navigateFromSplashToLogin()
        }
    }

    override fun onSupportNavigateUp() = navHostFragment.findNavController().navigateUp()
}
