package com.peterkrauz.rpgachievements.login

import com.peterkrauz.presentation.common_ui.base.BaseFragment
import org.koin.android.ext.android.inject

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel by inject<LoginViewModel>()

}
