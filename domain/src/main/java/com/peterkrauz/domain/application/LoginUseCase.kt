package com.peterkrauz.domain.application

interface LoginUseCase {
    suspend fun login(email: String, password: String)
}
