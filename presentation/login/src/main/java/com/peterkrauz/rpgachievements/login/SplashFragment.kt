package com.peterkrauz.rpgachievements.login

import com.peterkrauz.presentation.common_ui.base.BaseFragment
import com.peterkrauz.presentation.common_ui.extensions.paintStatusBar

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun setupView() {
        super.setupView()
        paintStatusBar(R.color.black)
    }
}
