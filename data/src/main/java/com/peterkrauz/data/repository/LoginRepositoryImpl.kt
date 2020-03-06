package com.peterkrauz.data.repository

import com.peterkrauz.data.api.LoginApi
import com.peterkrauz.data.request.LoginRequestBody
import com.peterkrauz.domain.repository.login.LoginRepository

class LoginRepositoryImpl(private val loginApi: LoginApi) : LoginRepository {
    override suspend fun login(email: String, password: String) {
        val requestBody = LoginRequestBody(email, password)
        val response = loginApi.login(requestBody)
        if (!response.isSuccessful) throw Exception()
    }
}
