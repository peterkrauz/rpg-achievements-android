package com.peterkrauz.domain.entity

import org.threeten.bp.LocalDate

data class Rpg(
    val id: Int,
    val name: String,
    val description: String,
    val createdAt: LocalDate
)
