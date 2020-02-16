package com.peterkrauz.data.api

import com.peterkrauz.domain.entity.Player
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerApi {

    @GET("api/players")
    suspend fun getAll(): List<Player>

    @GET("api/players/{id}")
    suspend fun getById(@Path("id") id: Int): Player
}
