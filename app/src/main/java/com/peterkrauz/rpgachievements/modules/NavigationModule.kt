package com.peterkrauz.rpgachievements.modules

import com.peterkrauz.presentation.common_ui.routers.LoginRouter
import com.peterkrauz.rpgachievements.navigation.Navigator
import org.koin.dsl.module

val loginNavigationModule = module {

    single<LoginRouter> { Navigator }
}
