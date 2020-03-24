package com.peterkrauz.rpgachievements.achievements

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.peterkrauz.domain.entity.Player
import com.peterkrauz.domain.repository.PlayerRepository
import com.peterkrauz.domain.repository.RpgRepository
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import com.peterkrauz.presentation.common_ui.utils.BundleKeys
import com.peterkrauz.rpgachievements.achievements.model.AchievementView
import com.peterkrauz.rpgachievements.achievements.model.mapper.AchievementViewMapper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AchievementsViewModel(
    private val achievementDetails: Bundle,
    private val rpgRepository: RpgRepository,
    private val playerRepository: PlayerRepository,
    private val mapper: AchievementViewMapper
) : StatefulViewModel<AchievementsViewState>() {

    private var isShowingCompletedTasksOnly = false

    private val rpgId: Int by lazy { achievementDetails.getInt(BundleKeys.RPG_ID_KEY) }

    private val playerId: Int by lazy { achievementDetails.getInt(BundleKeys.PLAYER_ID_KEY) }

    init {
        loadScreen()
    }

    private fun loadScreen() {
        viewModelScope.launch {
            coroutineScope { putValue(AchievementsViewState.Loading) }
            coroutineScope { putValue(fetchRpgAsync().await()) }
            coroutineScope { putValue(fetchAchievementsAsync().await()) }
            coroutineScope { putValue(fetchPlayerCompletedAchievementsIdsAsync().await()) }
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
                fetchAchievements()
            )
        }
    }

    private suspend fun fetchAchievements(): List<AchievementView> {
        return rpgRepository.getAchievementsForRpg(rpgId).map(mapper::map).sortedBy { it.title }
    }

    private suspend fun fetchPlayerCompletedAchievementsIdsAsync(): Deferred<AchievementsViewState.CompletedAchievementsIdsSuccess> {
        return viewModelScope.async {
            AchievementsViewState.CompletedAchievementsIdsSuccess(
                fetchPlayer().achievements
            )
        }
    }

    private suspend fun fetchPlayer(): Player {
        return playerRepository.getById(playerId)
    }

    fun filterCompleted() {
        isShowingCompletedTasksOnly = !isShowingCompletedTasksOnly
        viewModelScope.launch {
            if (isShowingCompletedTasksOnly) {
                filterCompletedAchievements()
            } else {
                filterNone()
            }
        }
    }

    private suspend fun filterCompletedAchievements() {
        val player = fetchPlayer()
        val filteredAchievements = fetchAchievements()
            .filter { achiev -> achiev.id in player.achievements }

        putValue(AchievementsViewState.AchievementListSuccess(filteredAchievements))
    }

    private suspend fun filterNone() {
        putValue(fetchAchievementsAsync().await())
    }

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {
        putValue(AchievementsViewState.Failure(error))
    }

    fun onRefresh() {
        loadScreen()
    }
}
