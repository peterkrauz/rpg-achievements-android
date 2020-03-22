package com.peterkrauz.rpgachievements.achievements

import androidx.recyclerview.widget.LinearLayoutManager
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.extensions.getColorCompat
import com.peterkrauz.presentation.common_ui.utils.BundleKeys
import com.peterkrauz.rpgachievements.achievements.list.AchievementAdapter
import kotlinx.android.synthetic.main.fragment_achievements.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AchievementsFragment : StatefulFragment<AchievementsViewState>(R.layout.fragment_achievements) {

    private val args by lazy { requireArguments() }

    private val adapter by lazy { AchievementAdapter() }

    override val viewModel by inject<AchievementsViewModel> {
        parametersOf(args)
    }

    override fun setupView() {
        recyclerViewAchievements.apply {
            adapter = this@AchievementsFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        swipeRefreshLayout.apply {
            isEnabled = true
            setOnRefreshListener { viewModel.onRefresh() }
            setColorSchemeColors(getColorCompat(R.color.colorAccent))
        }
    }

    override fun setViewState(viewState: AchievementsViewState) {
        swipeRefreshLayout.isRefreshing = viewState == AchievementsViewState.Loading
        when (viewState) {
            is AchievementsViewState.RpgNameSuccess -> {
                adapter.rpgName = viewState.rpgName
            }
            is AchievementsViewState.AchievementListSuccess -> {
                adapter.achievements = viewState.achievements
            }
            is AchievementsViewState.CompletedAchievementsIdsSuccess -> {
                adapter.completedAchievements = viewState.ids
            }
        }
    }
}
