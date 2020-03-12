package com.peterkrauz.home.activity

import androidx.lifecycle.viewModelScope
import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.home.model.mapper.RpgViewMapper
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val getRpgsUseCase: GetRpgsUseCase,
    private val rpgMapper: RpgViewMapper
) : StatefulViewModel<HomeViewState>() {

    init {
        fetchRpgs()
    }

    private fun fetchRpgs() {
        viewModelScope.launch(baseErrorHandler) {
            postValue(HomeViewState.Loading)
            postValue(
                HomeViewState.RpgListSuccess(
                    withContext(Dispatchers.IO) {
                        getRpgsUseCase.get().map(rpgMapper::map)
                    }
                )
            )
            postValue(HomeViewState.Loading)
        }
    }

    fun onRpgClick(rpg: RpgView) {

    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        postValue(HomeViewState.Failure(error))
    }
}
