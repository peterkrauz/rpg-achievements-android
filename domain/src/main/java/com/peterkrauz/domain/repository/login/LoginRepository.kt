package com.peterkrauz.domain.repository.login

import com.peterkrauz.domain.entity.AuthorizationToken

interface LoginRepository {
    suspend fun login(username: String, password: String): AuthorizationToken
}
