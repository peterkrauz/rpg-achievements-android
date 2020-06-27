package com.peterkrauz.data.api

import com.peterkrauz.data.dto.PlayerDto
import com.peterkrauz.data.request.TokenRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlayerApi {

    @GET("api/players/")
    suspend fun getAll(): Response<List<PlayerDto>>

    @GET("api/players/{playerId}/")
    suspend fun getById(@Path("playerId") id: Int): Response<PlayerDto>

    @POST("api/players/token/")
    suspend fun getPlayerByToken(@Body body: TokenRequestBody): Response<PlayerDto>
}
