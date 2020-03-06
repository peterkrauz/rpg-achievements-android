package com.peterkrauz.domain.usecase

import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.repository.login.LoginRepository

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun login(email: String, password: String) = loginRepository.login(email, password)
}
