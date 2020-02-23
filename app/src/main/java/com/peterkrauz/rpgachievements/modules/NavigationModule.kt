package com.peterkrauz.rpgachievements.modules

import com.peterkrauz.presentation.common_ui.LoginRouter
import com.peterkrauz.rpgachievements.navigation.Navigator
import org.koin.dsl.module

val navigationModule = module {

    single<LoginRouter> { Navigator }
}
