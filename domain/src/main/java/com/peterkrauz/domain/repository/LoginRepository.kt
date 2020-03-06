package com.peterkrauz.domain.repository

interface LoginRepository {
    suspend fun login(email: String, password: String)
}
