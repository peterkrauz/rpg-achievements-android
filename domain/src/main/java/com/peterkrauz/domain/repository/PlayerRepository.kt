package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.Player

interface PlayerRepository {
    suspend fun getAll(): List<Player>
    suspend fun getById(): Player
}
