package com.peterkrauz.home.activity

import androidx.lifecycle.viewModelScope
import com.peterkrauz.domain.application.GetPlayerUseCase
import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.home.model.mapper.RpgViewMapper
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val getRpgsUseCase: GetRpgsUseCase,
    private val getPlayerUseCase: GetPlayerUseCase,
    private val rpgMapper: RpgViewMapper,
    private val sessionStore: SessionStore
) : StatefulViewModel<HomeViewState>() {

    init {
        fetchPlayer()
        fetchRpgs()
    }

    private fun fetchPlayer() {
        putValue(HomeViewState.Loading)
        if (sessionStore.hasPlayer()) {
            fetchPlayerLocally()
        } else {
            fetchPlayerRemotely()
        }
    }

    private fun fetchPlayerLocally() {
        putValue(HomeViewState.PlayerNameSuccess(sessionStore.getPlayerMinimal().name))
    }

    private fun fetchPlayerRemotely() {
        viewModelScope.launch(baseErrorHandler) {
            val authToken = sessionStore.getToken()
            val player = getPlayerUseCase.get(authToken)
            putValue(HomeViewState.PlayerNameSuccess(player.name))
        }
    }

    private fun fetchRpgs() {
        viewModelScope.launch(baseErrorHandler) {
            putValue(HomeViewState.Loading)
            putValue(
                HomeViewState.RpgListSuccess(
                    getRpgsUseCase.get().map(rpgMapper::map)
                )
            )
        }
    }

    fun onRpgClick(rpg: RpgView) {

    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        putValue(HomeViewState.Failure(error))
    }

    fun onRefresh() {
        fetchPlayer()
        fetchRpgs()
    }
}
