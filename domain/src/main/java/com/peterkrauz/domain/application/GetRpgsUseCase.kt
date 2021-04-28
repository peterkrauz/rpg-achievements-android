package com.peterkrauz.domain.application

import com.peterkrauz.domain.entity.Rpg

interface GetRpgsUseCase {
    suspend fun get(): List<Rpg>
}
