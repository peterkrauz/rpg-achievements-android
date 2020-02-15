package com.peterkrauz.domain

data class Achievement(
    val id: Int,
    val rpgId: Int,
    val completed: Boolean,
    val description: String
)
