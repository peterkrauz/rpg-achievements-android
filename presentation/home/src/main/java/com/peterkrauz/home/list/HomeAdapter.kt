package com.peterkrauz.home.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.peterkrauz.home.R
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.presentation.common_ui.extensions.inflate

class HomeAdapter(
    private val onRpgClick: (RpgView) -> Unit
) : ListAdapter<HomeListItem, HomeViewHolder>(HomeDiffCallback) {

    var playerName: String = ""
        set(value) {
            field = value
            buildList()
        }

    var rpgs = listOf<RpgView>()
        set(value) {
            field = value
            buildList()
        }

    private fun buildList() {
        if (playerName.isBlank()) return

        val headerItem = WelcomeHeaderItem(playerName)
        val rpgItems = rpgs.map(::RpgItem)

        val fullList = mutableListOf<HomeListItem>()
        fullList.add(headerItem)
        fullList.addAll(rpgItems)

        submitList(fullList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            WELCOME_HEADER_TYPE -> WelcomeHeaderViewHolder(inflate(R.layout.item_welcome_header, parent))
            RPG_ITEM_TYPE -> RpgViewHolder(inflate(R.layout.item_rpg, parent))
            else -> throw IllegalArgumentException("No ViewHolder found for $viewType")
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        return when (val item = getItem(position)) {
            is RpgItem -> (holder as RpgViewHolder).bind(item, onRpgClick)
            is WelcomeHeaderItem -> (holder as WelcomeHeaderViewHolder).bind(item.playerName)
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).itemType

    private object HomeDiffCallback : DiffUtil.ItemCallback<HomeListItem>() {
        override fun areItemsTheSame(old: HomeListItem, new: HomeListItem) = when {
            old is WelcomeHeaderItem && new is WelcomeHeaderItem -> {
                old == new
            }
            old is RpgItem && new is RpgItem -> {
                old.rpg.id == new.rpg.id
            }
            else -> throw IllegalStateException("Home Diff Callback error")
        }

        override fun areContentsTheSame(old: HomeListItem, new: HomeListItem): Boolean {
            return old == new
        }
    }
}
