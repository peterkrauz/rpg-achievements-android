package com.peterkrauz.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthorizationTokenDto(
    @Json(name = "token") val authToken: String
)
