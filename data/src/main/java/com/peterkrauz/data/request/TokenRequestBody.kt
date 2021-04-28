package com.peterkrauz.data.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenRequestBody(
    @Json(name = "auth_token") val token: String
)
