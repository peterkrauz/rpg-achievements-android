package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Achievement

interface AchievementRepository {
    suspend fun getAll(): List<Achievement>
    suspend fun getById(): Achievement
}
