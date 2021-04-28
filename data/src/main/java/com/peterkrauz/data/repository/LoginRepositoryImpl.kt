package com.peterkrauz.data.repository

import com.peterkrauz.data.api.SessionApi
import com.peterkrauz.data.mapper.AuthorizationTokenMapper
import com.peterkrauz.data.request.LoginRequestBody
import com.peterkrauz.domain.repository.login.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepositoryImpl(
    private val sessionApi: SessionApi,
    private val mapper: AuthorizationTokenMapper
) : LoginRepository {

    override suspend fun login(username: String, password: String) = withContext(Dispatchers.IO) {
        val requestBody = LoginRequestBody(username, password)
        val response = sessionApi.login(requestBody)
        if (!response.isSuccessful) throw Exception()
        mapper.map(response.body() ?: throw Exception())
    }
}
