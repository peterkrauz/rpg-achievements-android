package com.peterkrauz.domain.usecase

import com.peterkrauz.domain.application.GetPlayerUseCase
import com.peterkrauz.domain.entity.AuthorizationToken
import com.peterkrauz.domain.repository.PlayerRepository

class GetPlayerUseCaseImpl(
    private val playerRepository: PlayerRepository
) : GetPlayerUseCase {
    override suspend fun get(authToken: AuthorizationToken) = playerRepository.getByToken(authToken)
}
