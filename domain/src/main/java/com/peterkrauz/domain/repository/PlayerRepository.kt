package com.peterkrauz.domain.repository

import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player

interface PlayerRepository {
    suspend fun getAll(): List<Player>
    suspend fun getById(): Player
    suspend fun getByToken(authToken: AuthorizationToken): Player
}
