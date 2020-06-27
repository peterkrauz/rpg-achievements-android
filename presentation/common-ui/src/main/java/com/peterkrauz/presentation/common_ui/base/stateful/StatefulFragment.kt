package com.peterkrauz.presentation.common_ui.base.stateful

import androidx.annotation.LayoutRes
import androidx.lifecycle.observe
import com.peterkrauz.presentation.common_ui.base.BaseFragment
import com.peterkrauz.presentation.common_ui.base.BaseViewState

abstract class StatefulFragment<ViewState : BaseViewState>(@LayoutRes layoutId: Int) : BaseFragment(layoutId) {

    abstract val viewModel: StatefulViewModel<ViewState>

    override fun setupObservers() {
        viewModel.viewState.observe(this, ::setViewState)
    }

    abstract fun setViewState(viewState: ViewState)
}
