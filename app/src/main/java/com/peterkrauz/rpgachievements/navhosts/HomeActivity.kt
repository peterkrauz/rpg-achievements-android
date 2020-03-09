package com.peterkrauz.rpgachievements.navhosts

import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.di.components.HomeComponent
import com.peterkrauz.rpgachievements.navhosts.base.BaseActivity
import com.peterkrauz.rpgachievements.navigator.Navigator
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
