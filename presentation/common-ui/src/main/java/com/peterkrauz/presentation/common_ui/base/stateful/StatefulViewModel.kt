package com.peterkrauz.presentation.common_ui.base.stateful

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peterkrauz.presentation.common_ui.base.BaseViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class StatefulViewModel<ViewState : BaseViewState> : ViewModel(), KoinComponent {

    protected val baseErrorHandler = CoroutineExceptionHandler(::handleError)

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    abstract fun handleError(errorContext: CoroutineContext, error: Throwable)

    protected fun putValue(state: ViewState) {
        _viewState.value = state
    }
}