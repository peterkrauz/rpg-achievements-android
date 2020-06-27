package com.peterkrauz.domain.application.session

import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player
import com.peterkrauz.domain.entity.minimal.PlayerMinimal

interface SessionStore {
    fun cacheToken(authToken: AuthorizationToken)
    suspend fun getToken(): AuthorizationToken
    fun cachePlayer(player: Player)
    fun getPlayerMinimal(): PlayerMinimal
    fun clear()

    fun hasSession(): Boolean
    fun hasPlayer(): Boolean
}
