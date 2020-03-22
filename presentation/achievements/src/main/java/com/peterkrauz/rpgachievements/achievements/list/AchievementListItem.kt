package com.peterkrauz.rpgachievements.achievements.list

import com.peterkrauz.rpgachievements.achievements.model.AchievementView

const val ACHIEVEMENT_ITEM_TYPE = 1
const val ACHIEVEMENT_HEADER_TYPE = 2

sealed class AchievementListItem {
    abstract val itemType: Int
}

class AchievementHeader(val rpgName: String) : AchievementListItem() {
    override val itemType = ACHIEVEMENT_HEADER_TYPE
}

class AchievementItem(val achievement: AchievementView) : AchievementListItem() {
    override val itemType = ACHIEVEMENT_ITEM_TYPE
}
