package com.peterkrauz.rpgachievements.achievements

import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.utils.BundleKeys
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AchievementsFragment : StatefulFragment<AchievementsViewState>(R.layout.fragment_achievements) {

    private val args by lazy { requireArguments() }

    override val viewModel by inject<AchievementsViewModel> {
        parametersOf(args[BundleKeys.RPG_ID_KEY])
    }

    override fun setViewState(viewState: AchievementsViewState) {

    }
}
