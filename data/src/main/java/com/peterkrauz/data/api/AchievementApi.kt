package com.peterkrauz.data.api

import com.peterkrauz.data.dto.AchievementDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AchievementApi {

    @GET("api/achievements/")
    suspend fun getAll(): List<AchievementDto>

    @GET("api/achievements/{achievementId}/")
    suspend fun getById(@Path("achievementId") id: Int): AchievementDto
}
