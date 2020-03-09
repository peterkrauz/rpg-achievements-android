package com.peterkrauz.rpgachievements.navhost

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.BaseActivity
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.modules.LoginComponent
import com.peterkrauz.rpgachievements.navigation.Navigator
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LandingActivity : BaseActivity(R.layout.activity_landing) {

    override val modules = listOf(*(LoginComponent.modules().toTypedArray()))

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
