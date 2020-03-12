package com.peterkrauz.home.activity

import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import kotlin.coroutines.CoroutineContext

class HomeViewModel : StatefulViewModel<HomeViewState>() {

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {

    }
}
