package com.peterkrauz.rpgachievements.login.splash

import com.peterkrauz.presentation.common_ui.base.BaseFragment
import com.peterkrauz.presentation.common_ui.extensions.paintStatusBar
import com.peterkrauz.rpgachievements.login.R

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun setupView() {
        super.setupView()
        paintStatusBar(R.color.darkGrey)
    }
}
