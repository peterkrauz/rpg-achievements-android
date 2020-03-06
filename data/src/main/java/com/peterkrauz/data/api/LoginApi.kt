package com.peterkrauz.data.api

import com.peterkrauz.data.request.LoginRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST
    suspend fun login(@Body body: LoginRequestBody): Response<Unit>
}
