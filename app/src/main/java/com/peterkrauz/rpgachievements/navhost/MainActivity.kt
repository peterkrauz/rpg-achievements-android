package com.peterkrauz.rpgachievements.navhost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.modules.navigationModule
import com.peterkrauz.rpgachievements.navigation.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.context.loadKoinModules

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.RpgAchievements)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadKoinModules(navigationModule)
    }

    override fun onResume() {
        super.onResume()
        Navigator.bind(navHostFragment.findNavController())

        lifecycleScope.launch {
            delay(1250)
            Navigator.navigateFromSplashToLogin()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Navigator.bind(navHostFragment.findNavController())
    }

    override fun onSupportNavigateUp(): Boolean =
        navHostFragment.findNavController().navigateUp()
}
