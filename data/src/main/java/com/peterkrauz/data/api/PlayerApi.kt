package com.peterkrauz.data.api

import com.peterkrauz.data.dto.PlayerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerApi {

    @GET("api/v1/players")
    suspend fun getAll(): List<PlayerDto>

    @GET("api/v1/players/{id}")
    suspend fun getById(@Path("id") id: Int): PlayerDto
}
