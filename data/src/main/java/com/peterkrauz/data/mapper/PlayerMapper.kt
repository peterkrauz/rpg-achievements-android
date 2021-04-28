package com.peterkrauz.data.mapper

import com.peterkrauz.data.dto.PlayerDto
import com.peterkrauz.domain.entity.Player
import com.peterkrauz.domain.mapper.Mapper

class PlayerMapper : Mapper<PlayerDto, Player> {
    override fun map(dto: PlayerDto): Player {
        return Player(
            dto.id,
            dto.name,
            dto.achievements,
            dto.authToken
        )
    }
}
