package com.peterkrauz.rpgachievements.modules

import com.peterkrauz.home.HomeViewModel
import org.koin.dsl.module

object HomeComponent : DIComponent {

    override val dataModule = module { }

    override val domainModule = module { }

    override val presentationModule = module {
        single { HomeViewModel() }
    }

    override val navigationModule = module { }
}
