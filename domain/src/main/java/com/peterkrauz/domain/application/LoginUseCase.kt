package com.peterkrauz.domain.application

import com.peterkrauz.domain.entity.AuthorizationToken

interface LoginUseCase {
    suspend fun login(username: String, password: String): AuthorizationToken
}
