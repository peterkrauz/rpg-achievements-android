package com.peterkrauz.home.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.peterkrauz.home.R
import com.peterkrauz.home.list.HomeAdapter
import com.peterkrauz.presentation.common_ui.base.stateful.StatefulFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class HomeFragment : StatefulFragment<HomeViewState>(R.layout.fragment_home) {

    override val viewModel by inject<HomeViewModel>()

    private val adapter by lazy { HomeAdapter(viewModel::onRpgClick) }

    override fun setupView() {
        recyclerViewRpgs.apply {
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun setViewState(viewState: HomeViewState) {
        when (viewState) {
            is HomeViewState.RpgListSuccess -> adapter.rpgs = viewState.rpgs
            is HomeViewState.PlayerNameSuccess -> adapter.playerName = viewState.playerName
        }
    }
}
