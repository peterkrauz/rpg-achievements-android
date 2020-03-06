package com.peterkrauz.domain.repository.login

interface LoginRepository {
    suspend fun login(email: String, password: String)
}
