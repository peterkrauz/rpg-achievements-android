package com.peterkrauz.data.dto

import com.squareup.moshi.Json

data class AchievementDto(
    @Json(name = "id") val id: Int,
    @Json(name = "rpg_id") val rpgId: Int,
    @Json(name = "completed") val completed: Boolean,
    @Json(name = "description") val description: String
)
