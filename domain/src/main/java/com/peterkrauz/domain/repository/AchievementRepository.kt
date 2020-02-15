package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Achievement

interface AchievementRepository {
    fun getAll(): List<Achievement>
    fun getById(): Achievement
}
