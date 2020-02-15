package com.peterkrauz.domain.entity

data class Achievement(
    val id: Int,
    val rpgId: Int,
    val completed: Boolean,
    val description: String
)
