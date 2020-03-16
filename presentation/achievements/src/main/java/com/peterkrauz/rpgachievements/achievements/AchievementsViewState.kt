package com.peterkrauz.rpgachievements.achievements

import com.peterkrauz.presentation.common_ui.base.BaseViewState

sealed class AchievementsViewState : BaseViewState {
    object Loading : AchievementsViewState()
}
