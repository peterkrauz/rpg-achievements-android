package com.peterkrauz.rpgachievements.achievements.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.peterkrauz.rpgachievements.achievements.R
import kotlinx.android.synthetic.main.item_achievement.view.*
import kotlinx.android.synthetic.main.item_achievements_header.view.*

sealed class AchievementItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

class AchievementViewHolder(view: View) : AchievementItemViewHolder(view) {

    fun bind(item: AchievementItem, isCompleted: Boolean) = with(itemView) {
        item.achievement.run {
            imageViewAchievementIcon.setImageDrawable(
                context.resources.getDrawable(getAchievementIcon(isCompleted), null)
            )
            textViewAchievementTitle.text = title
            textViewAchievementDescription.text = description
        }
    }

    private fun getAchievementIcon(isCompleted: Boolean): Int {
        return if (isCompleted) R.drawable.ic_achiev_completed else R.drawable.ic_achiev_ongoing
    }
}

class AchievementHeaderViewHolder(view: View) : AchievementItemViewHolder(view) {

    fun bind(rpgName: String) = with(itemView) {
        textViewAchievementsHeader.text = context.getString(R.string.achievements_for, rpgName)
    }
}
