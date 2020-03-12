package com.peterkrauz.data.repository

import com.peterkrauz.data.api.RpgApi
import com.peterkrauz.data.mapper.AchievementMapper
import com.peterkrauz.data.mapper.RpgMapper
import com.peterkrauz.domain.entity.Achievement
import com.peterkrauz.domain.entity.Rpg
import com.peterkrauz.domain.repository.RpgRepository

class RpgRepositoryImpl(
    private val rpgApi: RpgApi,
    private val rpgMapper: RpgMapper,
    private val achievementMapper: AchievementMapper
) : RpgRepository {

    override suspend fun getAll(): List<Rpg> {
        return rpgApi.getAll().map(rpgMapper::map)
    }

    override suspend fun getById(id: Int): Rpg {
        return rpgMapper.map(rpgApi.getById(id))
    }

    override suspend fun getAchievementsForRpg(rpgId: Int): List<Achievement> {
        return rpgApi.getAchievementsForRpg(rpgId).map(achievementMapper::map)
    }
}
