package com.peterkrauz.rpgachievements.navhost

import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.BaseActivity
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.modules.HomeComponent
import com.peterkrauz.rpgachievements.navigation.Navigator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(R.layout.activity_home) {

    override val modules = listOf(*HomeComponent.modules().toTypedArray())

    override fun onResume() {
        super.onResume()
        Navigator.bind(navHostFragment.findNavController())
    }

    override fun onDestroy() {
        super.onDestroy()
        Navigator.unBind()
    }

    override fun onSupportNavigateUp() = navHostFragment.findNavController().navigateUp()
}
