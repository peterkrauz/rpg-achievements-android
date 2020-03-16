package com.peterkrauz.rpgachievements.achievements

import com.peterkrauz.presentation.common_ui.base.stateful.StatefulViewModel
import kotlin.coroutines.CoroutineContext

class AchievementsViewModel(private val rpgId: Int) : StatefulViewModel<AchievementsViewState>() {

    override fun handleError(errorContext: CoroutineContext, error: Throwable) {

    }
}
