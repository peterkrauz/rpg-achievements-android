package com.peterkrauz.home.activity

import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.home.R
import com.peterkrauz.home.list.HomeAdapter
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import com.peterkrauz.presentation.common_ui.extensions.getColorCompat
import com.peterkrauz.presentation.common_ui.routers.HomeRouter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeFragment : StatefulFragment<HomeViewState>(R.layout.fragment_home) {

    private val homeRouter by inject<HomeRouter>()

    private val sessionStore by inject<SessionStore> {
        parametersOf(requireContext())
    }

    override val viewModel by inject<HomeViewModel> {
        parametersOf(sessionStore)
    }

    private val adapter by lazy { HomeAdapter(viewModel::onRpgClick) }

    override fun setupView() {
        recyclerViewRpgs.apply {
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        swipeRefreshLayout.apply {
            isEnabled = true
            setOnRefreshListener { viewModel.onRefresh() }
            setColorSchemeColors(getColorCompat(R.color.colorAccent))
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.rpgClickedLiveEvent.observe(this, ::navigateToRpgScreen)
    }

    private fun navigateToRpgScreen(rpgExtra: Bundle) {
        homeRouter.navigateFromHomeToAchievements(rpgExtra)
    }

    override fun setViewState(viewState: HomeViewState) {
        swipeRefreshLayout.isRefreshing = viewState == HomeViewState.Loading
        when (viewState) {
            is HomeViewState.RpgListSuccess -> {
                adapter.rpgs = viewState.rpgs
            }
            is HomeViewState.PlayerNameSuccess -> {
                adapter.playerName = viewState.playerName
            }
        }
    }
}
