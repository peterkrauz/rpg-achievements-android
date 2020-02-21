package com.peterkrauz.data.api

import com.peterkrauz.data.dto.RpgDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RpgApi {

    @GET("api/v1/rpgs")
    suspend fun getAll(): List<RpgDto>

    @GET("api/v1/rpgs/{id}")
    suspend fun getById(@Path("id") id: Int): RpgDto
}
