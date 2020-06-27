package com.peterkrauz.domain.usecase

import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.domain.repository.RpgRepository

class GetRpgsUseCaseImpl(
    private val rpgRepository: RpgRepository
) : GetRpgsUseCase {
    override suspend fun get() = rpgRepository.getAll()
}
