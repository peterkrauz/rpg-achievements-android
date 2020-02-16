package com.peterkrauz.data.api

import com.peterkrauz.domain.entity.Achievement
import retrofit2.http.GET
import retrofit2.http.Path

interface AchievementApi {

    @GET("api/achievements")
    suspend fun getAll(): List<Achievement>

    @GET("api/achievements/{id}")
    suspend fun getById(@Path("id") id: Int): Achievement
}
