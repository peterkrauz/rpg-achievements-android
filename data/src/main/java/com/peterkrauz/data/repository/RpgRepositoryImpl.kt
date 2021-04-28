package com.peterkrauz.data.repository

import com.peterkrauz.data.api.RpgApi
import com.peterkrauz.data.mapper.AchievementMapper
import com.peterkrauz.data.mapper.RpgMapper
import com.peterkrauz.domain.repository.RpgRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RpgRepositoryImpl(
    private val rpgApi: RpgApi,
    private val rpgMapper: RpgMapper,
    private val achievementMapper: AchievementMapper
) : RpgRepository {

    override suspend fun getAll() = withContext(Dispatchers.IO) {
        rpgApi.getAll().map(rpgMapper::map)
    }

    override suspend fun getById(id: Int) = withContext(Dispatchers.IO) {
        rpgMapper.map(rpgApi.getById(id))
    }

    override suspend fun getAchievementsForRpg(rpgId: Int) = withContext(Dispatchers.IO) {
        rpgApi.getAchievementsForRpg(rpgId).map(achievementMapper::map)
    }
}
