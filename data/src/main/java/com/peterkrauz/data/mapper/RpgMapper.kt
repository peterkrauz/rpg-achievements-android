package com.peterkrauz.data.mapper

import com.peterkrauz.data.dto.RpgDto
import com.peterkrauz.domain.entity.Rpg
import com.peterkrauz.domain.mapper.Mapper

class RpgMapper : Mapper<RpgDto, Rpg> {
    override fun map(dto: RpgDto): Rpg {
        return Rpg(
            dto.id,
            dto.title,
            dto.description,
            dto.createdAt
        )
    }
}
