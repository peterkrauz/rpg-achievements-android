package com.peterkrauz.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "achievements") val achievements: List<Int>,
    @Json(name = "auth_token") val authToken: String
)
