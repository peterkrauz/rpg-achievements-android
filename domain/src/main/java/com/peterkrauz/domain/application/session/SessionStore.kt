package com.peterkrauz.domain.application.session

import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player

interface SessionStore {
    fun cacheToken(authToken: AuthorizationToken)
    fun cachePlayer(player: Player)
    fun clear()
    fun hasSession(): Boolean
}
