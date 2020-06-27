package com.peterkrauz.domain.application

import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player

interface GetPlayerUseCase {
    suspend fun get(authToken: AuthorizationToken): Player
}
