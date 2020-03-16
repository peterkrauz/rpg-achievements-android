package com.peterkrauz.home.activity

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.viewModelScope
import com.peterkrauz.common.SingleLiveEvent
import com.peterkrauz.domain.application.GetPlayerUseCase
import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.home.model.mapper.RpgViewMapper
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import com.peterkrauz.presentation.common_ui.utils.BundleKeys
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val getRpgsUseCase: GetRpgsUseCase,
    private val getPlayerUseCase: GetPlayerUseCase,
    private val rpgMapper: RpgViewMapper,
    private val sessionStore: SessionStore
) : StatefulViewModel<HomeViewState>() {

    val rpgClickedLiveEvent = SingleLiveEvent<Bundle>()

    init {
        loadScreen()
    }

    private fun loadScreen() {
        viewModelScope.launch {
            fetchPlayer()
            fetchRpgs()
        }
    }

    private suspend fun fetchPlayer() {
        putValue(HomeViewState.Loading)
        val fetchPlayerState = if (sessionStore.hasPlayer()) {
            fetchPlayerLocallyAsync()
        } else {
            fetchPlayerRemotelyAsync()
        }
        putValue(fetchPlayerState.await())
    }

    private fun fetchPlayerLocallyAsync(): Deferred<HomeViewState.PlayerNameSuccess> {
        return viewModelScope.async {
            HomeViewState.PlayerNameSuccess(
                sessionStore.getPlayerMinimal().name
            )
        }
    }

    private fun fetchPlayerRemotelyAsync(): Deferred<HomeViewState.PlayerNameSuccess> {
        return viewModelScope.async {
            val authToken = sessionStore.getToken()
            val player = getPlayerUseCase.get(authToken)
            HomeViewState.PlayerNameSuccess(player.name)
        }
    }

    private suspend fun fetchRpgs() {
        putValue(HomeViewState.Loading)
        putValue(
            HomeViewState.RpgListSuccess(
                viewModelScope.async {
                    getRpgsUseCase.get().map(rpgMapper::map)
                }.await()
            )
        )
    }

    fun onRpgClick(rpg: RpgView) {
        rpgClickedLiveEvent.value = bundleOf(
            BundleKeys.RPG_ID_KEY to rpg.id
        )
    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        putValue(HomeViewState.Failure(error))
    }

    fun onRefresh() {
        loadScreen()
    }
}
