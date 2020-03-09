package com.peterkrauz.rpgachievements.modules

import com.peterkrauz.data.ServiceFactory
import com.peterkrauz.data.api.SessionApi
import com.peterkrauz.data.mapper.AuthorizationTokenMapper
import com.peterkrauz.data.repository.LoginRepositoryImpl
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.repository.login.LoginRepository
import com.peterkrauz.domain.usecase.LoginUseCaseImpl
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.login.LoginViewModel
import com.peterkrauz.rpgachievements.navigation.Navigator
import org.koin.dsl.module

object LoginComponent : DIComponent {

    override val dataModule = module {
        single { AuthorizationTokenMapper() }
        single<LoginRepository> { LoginRepositoryImpl(sessionApi = get(), mapper = get()) }
        single<SessionApi> { ServiceFactory.createService() }
    }

    override val domainModule = module {
        single<LoginUseCase> { LoginUseCaseImpl(loginRepository = get()) }
    }

    override val presentationModule = module {
        single { LoginViewModel(loginUseCase = get()) }
    }

    override val navigationModule = module {
        single<LoginRouter> { Navigator }
    }
}
