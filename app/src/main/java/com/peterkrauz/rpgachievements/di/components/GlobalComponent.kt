package com.peterkrauz.rpgachievements.di.components

import android.content.Context
import com.peterkrauz.data.session.SessionStoreImpl
import com.peterkrauz.domain.application.session.SessionStore
import org.koin.dsl.module

object GlobalComponent {

    val sessionModule = module {
        single<SessionStore> { (appContext: Context) -> SessionStoreImpl(appContext) }
    }
}
