package com.peterkrauz.rpgachievements.navhost

import androidx.navigation.fragment.findNavController
import com.peterkrauz.rpgachievements.BaseActivity
import com.peterkrauz.rpgachievements.R
import com.peterkrauz.rpgachievements.navigation.Navigator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.navHostFragment
import kotlinx.android.synthetic.main.activity_landing.*
import org.koin.core.module.Module

class HomeActivity : BaseActivity(R.layout.activity_home) {

    override val modules = listOf<Module>()

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
