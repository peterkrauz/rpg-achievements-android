package com.peterkrauz.home.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.peterkrauz.home.R
import com.peterkrauz.home.model.RpgView
import com.peterkrauz.presentation.common_ui.extensions.inflate
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class HomeAdapter(
    private val onRpgClick: (RpgView) -> Unit
) : ListAdapter<HomeListItem, HomeViewHolder>(HomeDiffCallback) {

    private val rpgIcons by lazy {
        listOf(
            R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8,
            R.drawable.icon_9,
            R.drawable.icon_10,
            R.drawable.icon_11,
            R.drawable.icon_12,
            R.drawable.icon_13,
            R.drawable.icon_14,
            R.drawable.icon_15,
            R.drawable.icon_16,
            R.drawable.icon_17,
            R.drawable.icon_18
        )
    }

    private val randomSeed by lazy { rpgIcons.indices.random() }

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
            is RpgItem -> (holder as RpgViewHolder).bind(item, getRpgIcon(position), onRpgClick)
            is WelcomeHeaderItem -> (holder as WelcomeHeaderViewHolder).bind(item.playerName)
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).itemType

    private fun getRpgIcon(position: Int) = rpgIcons[(randomSeed + position) % rpgIcons.size]

    private object HomeDiffCallback : DiffUtil.ItemCallback<HomeListItem>() {
        override fun areItemsTheSame(old: HomeListItem, new: HomeListItem) = when {
            old is WelcomeHeaderItem && new is WelcomeHeaderItem -> {
                old.playerName == new.playerName
            }
            old is RpgItem && new is RpgItem -> {
                old.rpg.id == new.rpg.id
            }
            else -> false
        }

        override fun areContentsTheSame(old: HomeListItem, new: HomeListItem): Boolean {
            return old == new
        }
    }
}
