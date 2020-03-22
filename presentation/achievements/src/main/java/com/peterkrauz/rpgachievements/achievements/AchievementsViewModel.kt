package com.peterkrauz.rpgachievements.achievements

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.peterkrauz.domain.repository.PlayerRepository
import com.peterkrauz.domain.repository.RpgRepository
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import com.peterkrauz.presentation.common_ui.utils.BundleKeys
import com.peterkrauz.rpgachievements.achievements.model.mapper.AchievementViewMapper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AchievementsViewModel(
    private val achievementDetails: Bundle,
    private val rpgRepository: RpgRepository,
    private val playerRepository: PlayerRepository,
    private val mapper: AchievementViewMapper
) : StatefulViewModel<AchievementsViewState>() {

    private val rpgId: Int by lazy { achievementDetails.getInt(BundleKeys.RPG_ID_KEY) }

    private val playerId: Int by lazy { achievementDetails.getInt(BundleKeys.PLAYER_ID_KEY) }

    init {
        loadScreen()
    }

    private fun loadScreen() {
        viewModelScope.launch {
            putValue(AchievementsViewState.Loading)
            putValue(fetchRpgAsync().await())
            putValue(fetchAchievementsAsync().await())
            putValue(fetchPlayerIdAsync().await())
        }
    }

    private suspend fun fetchRpgAsync(): Deferred<AchievementsViewState.RpgNameSuccess> {
        return viewModelScope.async {
            AchievementsViewState.RpgNameSuccess(
                rpgRepository.getById(rpgId).title
            )
        }
    }

    private suspend fun fetchAchievementsAsync(): Deferred<AchievementsViewState.AchievementListSuccess> {
        return viewModelScope.async {
            AchievementsViewState.AchievementListSuccess(
                rpgRepository.getAchievementsForRpg(rpgId).map(mapper::map)
            )
        }
    }

    private suspend fun fetchPlayerIdAsync(): Deferred<AchievementsViewState.CompletedAchievementsIdsSuccess> {
        return viewModelScope.async {
            AchievementsViewState.CompletedAchievementsIdsSuccess(
                playerRepository.getById(playerId).achievements
            )
        }
    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        putValue(AchievementsViewState.Failure(error))
    }

    fun onRefresh() {
        loadScreen()
    }
}
