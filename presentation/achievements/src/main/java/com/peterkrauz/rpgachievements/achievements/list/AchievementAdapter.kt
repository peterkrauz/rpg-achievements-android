package com.peterkrauz.rpgachievements.achievements.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.peterkrauz.presentation.common_ui.extensions.inflate
import com.peterkrauz.rpgachievements.achievements.R
import com.peterkrauz.rpgachievements.achievements.model.AchievementView

class AchievementAdapter : ListAdapter<AchievementListItem, AchievementItemViewHolder>(AchievementDiffCallback) {

    var rpgName: String = ""
        set(value) {
            field = value
            buildList()
        }

    var achievements = listOf<AchievementView>()
        set(value) {
            field = value
            buildList()
        }

    var completedAchievements = listOf<Int>()
        set(value) {
            field = value
            buildList()
        }

    private fun buildList() {
        if (rpgName.isBlank() || completedAchievements.isEmpty()) return

        val headerItem = AchievementHeader(rpgName)
        val achievementItems = achievements.map(::AchievementItem)

        val fullList = mutableListOf<AchievementListItem>()
        fullList.add(headerItem)
        fullList.addAll(achievementItems)

        submitList(fullList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementItemViewHolder {
        return when (viewType) {
            ACHIEVEMENT_HEADER_TYPE -> AchievementHeaderViewHolder(inflate(R.layout.item_achievements_header, parent))
            ACHIEVEMENT_ITEM_TYPE -> AchievementViewHolder(inflate(R.layout.item_achievement, parent))
            else -> throw IllegalArgumentException("No ViewHolder found for $viewType")
        }
    }

    override fun onBindViewHolder(holder: AchievementItemViewHolder, position: Int) {
        return when (val item = getItem(position)) {
            is AchievementItem -> {
                val isCompleted = item.achievement.id in completedAchievements
                (holder as AchievementViewHolder).bind(item, isCompleted)
            }
            is AchievementHeader -> (holder as AchievementHeaderViewHolder).bind(rpgName)
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).itemType

    private object AchievementDiffCallback : DiffUtil.ItemCallback<AchievementListItem>() {
        override fun areItemsTheSame(oldItem: AchievementListItem, newItem: AchievementListItem) = when {
            oldItem is AchievementHeader && newItem is AchievementHeader -> {
                oldItem.rpgName == newItem.rpgName
            }
            oldItem is AchievementItem && newItem is AchievementItem -> {
                oldItem.achievement.id == newItem.achievement.id
            }
            else -> false
        }

        override fun areContentsTheSame(oldItem: AchievementListItem, newItem: AchievementListItem): Boolean {
            return oldItem == newItem
        }
    }
}
