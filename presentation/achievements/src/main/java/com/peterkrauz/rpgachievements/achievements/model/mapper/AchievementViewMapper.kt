package com.peterkrauz.rpgachievements.achievements.model.mapper

import com.peterkrauz.domain.entity.Achievement
import com.peterkrauz.presentation.common_ui.mapper.ViewMapper
import com.peterkrauz.rpgachievements.achievements.model.AchievementView

class AchievementViewMapper : ViewMapper<Achievement, AchievementView> {

    override fun map(entity: Achievement): AchievementView {
        return AchievementView(
            entity.id,
            entity.title,
            entity.description
        )
    }
}
