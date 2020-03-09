package com.peterkrauz.rpgachievements.navhosts

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.di.components.LoginComponent
import com.peterkrauz.rpgachievements.navhosts.base.BaseActivity
import com.peterkrauz.rpgachievements.navigator.Navigator
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LandingActivity : BaseActivity(R.layout.activity_landing) {

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

        lifecycleScope.launch {
            delay(1250)

            if (sessionStore.hasSession()) {
                loginRouter.navigateFromSplashToHome()
            } else {
                loginRouter.navigateFromSplashToLogin()
            }
        }
    }

    override fun onSupportNavigateUp() = navHostFragment.findNavController().navigateUp()
}
