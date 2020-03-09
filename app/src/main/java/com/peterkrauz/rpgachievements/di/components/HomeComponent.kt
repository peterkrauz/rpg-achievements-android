package com.peterkrauz.rpgachievements.di.components

import android.content.Context
import com.peterkrauz.data.session.SessionStoreImpl
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.home.HomeViewModel
import com.peterkrauz.rpgachievements.di.DIComponent
import org.koin.dsl.module

object HomeComponent : DIComponent {

    override val dataModule = module { }

    override val domainModule = module {
        single<SessionStore> { (appContext: Context) -> SessionStoreImpl(appContext) }
    }

    override val presentationModule = module {
        single { HomeViewModel() }
    }

    override val navigationModule = module { }
}
