package com.peterkrauz.rpgachievements.modules

import org.koin.core.module.Module

interface DIComponent {

    val dataModule: Module
    val domainModule: Module
    val presentationModule: Module
    val navigationModule: Module

    fun modules() = listOf(dataModule, domainModule, presentationModule, navigationModule)
}
