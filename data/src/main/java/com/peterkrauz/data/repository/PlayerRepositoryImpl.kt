package com.peterkrauz.data.repository

import com.peterkrauz.data.api.PlayerApi
import com.peterkrauz.data.mapper.PlayerMapper
import com.peterkrauz.data.request.TokenRequestBody
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.entity.Player
import com.peterkrauz.domain.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlayerRepositoryImpl(
    private val playerApi: PlayerApi,
    private val playerMapper: PlayerMapper
) : PlayerRepository {

    override suspend fun getAll(): List<Player> {
        TODO("not implemented")
    }

    override suspend fun getById(playerId: Int) = withContext(Dispatchers.IO) {
        val response = playerApi.getById(playerId)
        if (!response.isSuccessful) throw Exception()
        playerMapper.map(response.body() ?: throw Exception())
    }

    override suspend fun getByToken(authToken: AuthorizationToken) = withContext(Dispatchers.IO) {
        val requestBody = TokenRequestBody(authToken.authToken)
        val response = playerApi.getPlayerByToken(requestBody)
        if (!response.isSuccessful) throw Exception()
        playerMapper.map(response.body() ?: throw Exception())
    }
}