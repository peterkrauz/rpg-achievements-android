package com.peterkrauz.rpgachievements.navhosts

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.di.components.LoginComponent
import com.peterkrauz.rpgachievements.navhosts.base.BaseActivity
import com.peterkrauz.rpgachievements.navigator.Navigator
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LandingActivity : BaseActivity(R.layout.activity_landing) {

    override val modules = LoginComponent.modules()

    override fun doPreCreation() {
        setTheme(R.style.RpgAchievements)
    }

    override fun onResume() {
        super.onResume()
        Navigator.bind(navHostFragment.findNavController())

        lifecycleScope.launch {
            delay(1250)
            Navigator.navigateFromSplashToLogin()
        }
    }

    override fun onSupportNavigateUp() = navHostFragment.findNavController().navigateUp()
}
