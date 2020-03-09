package com.peterkrauz.rpgachievements.di

import org.koin.core.module.Module

interface DIComponent {

    val dataModule: Module
    val domainModule: Module
    val presentationModule: Module
    val navigationModule: Module

    fun modules() = listOf(dataModule, domainModule, presentationModule, navigationModule)
}
