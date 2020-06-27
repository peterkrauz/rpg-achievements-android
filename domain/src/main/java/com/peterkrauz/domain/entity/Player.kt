package com.peterkrauz.domain.entity

data class Player(
    val id: Int,
    val name: String,
    val achievements: List<Int>,
    val authToken: String
)
