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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            WELCOME_HEADER_TYPE -> WelcomeHeaderViewHolder(inflate(R.layout.item_welcome_header, parent))
            RPG_ITEM_TYPE -> RpgViewHolder(inflate(R.layout.item_rpg, parent))
            else -> throw IllegalArgumentException("No ViewHolder found for $viewType")
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        return when (val item = getItem(position)) {
            is HomeListItem.RpgItem -> (holder as RpgViewHolder).bind(item, onRpgClick)
            is HomeListItem.WelcomeHeaderItem -> (holder as WelcomeHeaderViewHolder).bind(item.playerName)
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).itemType

    private object HomeDiffCallback : DiffUtil.ItemCallback<HomeListItem>() {
        override fun areItemsTheSame(old: HomeListItem, new: HomeListItem) = when {
            old is HomeListItem.WelcomeHeaderItem && new is HomeListItem.WelcomeHeaderItem -> {
                old == new
            }
            old is HomeListItem.RpgItem && new is HomeListItem.RpgItem -> {
                old.rpg.id == new.rpg.id
            }
            else -> throw IllegalStateException("Home Diff Callback error")
        }

        override fun areContentsTheSame(old: HomeListItem, new: HomeListItem): Boolean {
            return old == new
        }
    }
}
