package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Player

interface PlayerRepository {
    fun getAll(): List<Player>
    fun getById(): Player
}
