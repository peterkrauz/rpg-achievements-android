package com.peterkrauz.rpgachievements.login

import com.peterkrauz.presentation.common_ui.base.BaseFragment
import com.peterkrauz.presentation.common_ui.extensions.paintStatusBar

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    override fun setupView() {
        super.setupView()
        paintStatusBar(R.color.colorPrimary)
    }

}
