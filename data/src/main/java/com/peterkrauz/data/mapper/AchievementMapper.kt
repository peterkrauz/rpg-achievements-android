package com.peterkrauz.data.mapper

import com.peterkrauz.data.dto.AchievementDto
import com.peterkrauz.domain.entity.Achievement
import com.peterkrauz.domain.mapper.Mapper

class AchievementMapper : Mapper<AchievementDto, Achievement> {
    override fun map(dto: AchievementDto): Achievement {
        return Achievement(
            dto.id,
            dto.title,
            dto.description
        )
    }
}
