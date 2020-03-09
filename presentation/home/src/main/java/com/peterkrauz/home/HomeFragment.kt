package com.peterkrauz.home

import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import org.koin.android.ext.android.inject

class HomeFragment : StatefulFragment<HomeViewState>(R.layout.fragment_home) {

    override val viewModel by inject<HomeViewModel>()

    override fun setViewState(viewState: HomeViewState) {

    }
}
