package com.peterkrauz.data.session

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player

class SessionStoreImpl(private val appContext: Context) : SessionStore {

    private var hasSession: Boolean = false

    companion object {
        private const val SHARED_PREFS_KEY = "rpg_achievements_session_store"
        private const val AUTH_TOKEN_KEY = "rpg_achievements_auth_token"
        private const val PLAYER_NAME_KEY = "rpg_achievements_player_name"
        private const val PLAYER_ID_KEY = "rpg_achievements_player_ID"
    }

    private val sharedPrefs: SharedPreferences by lazy {
        appContext.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)
    }

    override fun cacheToken(authToken: AuthorizationToken) {
        sharedPrefs.edit {
            putString(AUTH_TOKEN_KEY, authToken.authToken)
        }.also {
            hasSession = true
        }
    }

    override fun cachePlayer(player: Player) {
        cachePlayerId(player.id)
        cachePlayerName(player.name)
    }

    private fun cachePlayerName(playerName: String) = sharedPrefs.edit {
        putString(PLAYER_NAME_KEY, playerName)
    }

    private fun cachePlayerId(playerId: Int) = sharedPrefs.edit {
        putInt(PLAYER_ID_KEY, playerId)
    }

    override fun clear() = sharedPrefs.edit {
        remove(AUTH_TOKEN_KEY)
        remove(PLAYER_NAME_KEY)
        remove(PLAYER_ID_KEY)
    }.also {
        hasSession = false
    }

    override fun hasSession(): Boolean = hasSession
}
