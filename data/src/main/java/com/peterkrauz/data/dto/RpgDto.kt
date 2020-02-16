package com.peterkrauz.data.dto

import com.squareup.moshi.Json
import org.threeten.bp.LocalDate

data class RpgDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "created_at") val createdAt: LocalDate
)
