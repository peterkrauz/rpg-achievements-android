package com.peterkrauz.data.session

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player
import com.peterkrauz.domain.entity.minimal.PlayerMinimal

class SessionStoreImpl(appContext: Context) : SessionStore {

    private var hasSession: Boolean = false
        set(value) {
            field = value
            storeSessionState()
        }

    private var hasPlayer: Boolean = false
        set(value) {
            field = value
            storeSessionState()
        }

    private var sharedPrefs: SharedPreferences

    init {
        sharedPrefs = appContext.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)
        recoverSessionState()
    }

    companion object {
        private const val SHARED_PREFS_KEY = "rpg_achievements_session_store"
        private const val AUTH_TOKEN_KEY = "rpg_achievements_auth_token"
        private const val PLAYER_NAME_KEY = "rpg_achievements_player_name"
        private const val PLAYER_ID_KEY = "rpg_achievements_player_id"
        private const val SESSION_STATE_KEY = "rpg_achievements_has_session"
        private const val PLAYER_STATE_KEY = "rpg_achievements_has_player"
    }

    override fun cacheToken(authToken: AuthorizationToken) {
        sharedPrefs.edit {
            putString(AUTH_TOKEN_KEY, authToken.authToken)
        }.also {
            hasSession = true
        }
    }

    override suspend fun getToken(): AuthorizationToken {
        return AuthorizationToken(
            sharedPrefs.getString(AUTH_TOKEN_KEY, "") ?: throw IllegalStateException()
        )
    }

    override fun getPlayerMinimal(): PlayerMinimal {
        return PlayerMinimal(
            sharedPrefs.getInt(PLAYER_ID_KEY, 0),
            sharedPrefs.getString(PLAYER_NAME_KEY, "Tatu-Chá") ?: throw Exception(),
            sharedPrefs.getString(AUTH_TOKEN_KEY, "ninja_turtle_456#$%") ?: throw Exception()
        )
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
        hasPlayer = false
    }

    override fun hasSession(): Boolean = hasSession

    override fun hasPlayer(): Boolean = hasPlayer

    private fun storeSessionState() {
        sharedPrefs.edit {
            putBoolean(SESSION_STATE_KEY, hasSession)
            putBoolean(PLAYER_STATE_KEY, hasPlayer)
        }
    }

    private fun recoverSessionState() {
        hasSession = sharedPrefs.getBoolean(SESSION_STATE_KEY, false)
        hasPlayer = sharedPrefs.getBoolean(PLAYER_STATE_KEY, false)
    }
}
