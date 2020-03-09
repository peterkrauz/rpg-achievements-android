package com.peterkrauz.rpgachievements.di.components

import com.peterkrauz.home.HomeViewModel
import com.peterkrauz.rpgachievements.di.DIComponent
import org.koin.dsl.module

object HomeComponent : DIComponent {

    override val dataModule = module { }

    override val domainModule = module { }

    override val presentationModule = module {
        single { HomeViewModel() }
    }

    override val navigationModule = module { }
}
