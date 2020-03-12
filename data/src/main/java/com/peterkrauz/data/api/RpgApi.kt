package com.peterkrauz.data.api

import com.peterkrauz.data.dto.AchievementDto
import com.peterkrauz.data.dto.RpgDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RpgApi {

    @GET("api/rpgs/")
    suspend fun getAll(): List<RpgDto>

    @GET("api/rpgs/{rpgId}/")
    suspend fun getById(@Path("rpgId") id: Int): RpgDto

    @GET("api/rpgs/{rpgId}/achievements/")
    suspend fun getAchievementsForRpg(@Path("rpgId") rpgId: Int): List<AchievementDto>
}
