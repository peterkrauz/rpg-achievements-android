package com.peterkrauz.data.api

import com.peterkrauz.data.dto.AuthorizationTokenDto
import com.peterkrauz.data.request.LoginRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SessionApi {

    @POST("login")
    suspend fun login(@Body body: LoginRequestBody): Response<AuthorizationTokenDto>
}
