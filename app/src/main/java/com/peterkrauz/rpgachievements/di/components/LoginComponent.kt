package com.peterkrauz.rpgachievements.di.components

import android.content.Context
import com.peterkrauz.data.ServiceFactory
import com.peterkrauz.data.api.SessionApi
import com.peterkrauz.data.mapper.AuthorizationTokenMapper
import com.peterkrauz.data.repository.LoginRepositoryImpl
import com.peterkrauz.data.session.SessionStoreImpl
import com.peterkrauz.domain.application.LoginUseCase
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.domain.repository.login.LoginRepository
import com.peterkrauz.domain.usecase.LoginUseCaseImpl
import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.di.DIComponent
import com.peterkrauz.rpgachievements.login.LoginViewModel
import com.peterkrauz.rpgachievements.navigator.Navigator
import org.koin.dsl.module

object LoginComponent : DIComponent {

    override val dataModule = module {
        single { AuthorizationTokenMapper() }
        single<LoginRepository> { LoginRepositoryImpl(sessionApi = get(), mapper = get()) }
        single<SessionApi> { ServiceFactory.createService() }
    }

    override val domainModule = module {
        factory<LoginUseCase> { LoginUseCaseImpl(loginRepository = get()) }
        single<SessionStore> { (appContext: Context) -> SessionStoreImpl(appContext) }
    }

    override val presentationModule = module {
        single { (appContext: Context) -> LoginViewModel(loginUseCase = get(), appContext = appContext) }
    }

    override val navigationModule = module {
        single<LoginRouter> { Navigator }
    }
}
