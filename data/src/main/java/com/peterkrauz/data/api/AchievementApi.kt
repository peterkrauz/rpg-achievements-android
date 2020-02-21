package com.peterkrauz.data.api

import com.peterkrauz.data.dto.AchievementDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AchievementApi {

    @GET("api/v1/achievements")
    suspend fun getAll(): List<AchievementDto>

    @GET("api/v1/achievements/{id}")
    suspend fun getById(@Path("id") id: Int): AchievementDto
}
