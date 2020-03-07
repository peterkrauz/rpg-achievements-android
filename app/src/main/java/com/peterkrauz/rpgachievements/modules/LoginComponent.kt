package com.peterkrauz.rpgachievements.modules

import com.peterkrauz.data.ServiceFactory
import com.peterkrauz.data.api.SessionApi
import com.peterkrauz.data.mapper.AuthorizationTokenMapper
import com.peterkrauz.data.repository.LoginRepositoryImpl
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.repository.login.LoginRepository
import com.peterkrauz.domain.usecase.LoginUseCaseImpl
import com.peterkrauz.rpgachievements.login.LoginViewModel
import org.koin.dsl.module

object LoginComponent {

    private val presentationModule = module {
        single { LoginViewModel(loginUseCase = get()) }
    }

    private val domainModule = module {
        single<LoginUseCase> { LoginUseCaseImpl(loginRepository = get()) }
    }

    private val dataModule = module {
        single { AuthorizationTokenMapper() }
        single<LoginRepository> { LoginRepositoryImpl(sessionApi = get(), mapper = get()) }
        single<SessionApi> { ServiceFactory.createService() }
    }

    fun modules() = listOf(presentationModule, domainModule, dataModule)
}

