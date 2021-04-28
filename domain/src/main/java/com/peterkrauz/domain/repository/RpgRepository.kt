package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Achievement
import com.peterkrauz.domain.entity.Rpg

interface RpgRepository {
    suspend fun getAll(): List<Rpg>
    suspend fun getById(id: Int): Rpg
    suspend fun getAchievementsForRpg(rpgId: Int): List<Achievement>
}
