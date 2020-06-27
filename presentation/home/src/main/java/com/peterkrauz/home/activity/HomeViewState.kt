package com.peterkrauz.home.activity

import com.peterkrauz.home.model.RpgView
import com.peterkrauz.presentation.common_ui.base.BaseViewState

sealed class HomeViewState : BaseViewState {
    object Loading : HomeViewState()
    class PlayerNameSuccess(val playerName: String) : HomeViewState()
    class RpgListSuccess(val rpgs: List<RpgView>) : HomeViewState()
    data class Failure(val error: Throwable) : HomeViewState()
}
