package com.peterkrauz.rpgachievements.achievements

import com.peterkrauz.presentation.common_ui.base.BaseViewState
import com.peterkrauz.rpgachievements.achievements.model.AchievementView

sealed class AchievementsViewState : BaseViewState {
    object Loading : AchievementsViewState()
    class RpgNameSuccess(val rpgName: String) : AchievementsViewState()
    class AchievementListSuccess(val achievements: List<AchievementView>) : AchievementsViewState()
    class CompletedAchievementsIdsSuccess(val ids: List<Int>) : AchievementsViewState()
    data class Failure(val error: Throwable) : AchievementsViewState()
}
