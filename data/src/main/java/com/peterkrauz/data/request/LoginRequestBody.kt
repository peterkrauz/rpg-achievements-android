package com.peterkrauz.data.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequestBody(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)
