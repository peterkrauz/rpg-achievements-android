package com.peterkrauz.rpgachievements.di.components

import com.peterkrauz.data.ServiceFactory
import com.peterkrauz.data.api.RpgApi
import com.peterkrauz.data.mapper.AchievementMapper
import com.peterkrauz.data.mapper.RpgMapper
import com.peterkrauz.data.repository.RpgRepositoryImpl
import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.domain.repository.RpgRepository
import com.peterkrauz.domain.usecase.GetRpgsUseCaseImpl
import com.peterkrauz.home.activity.HomeViewModel
import com.peterkrauz.home.model.mapper.RpgViewMapper
import com.peterkrauz.rpgachievements.di.DIComponent
import org.koin.dsl.module

object HomeComponent : DIComponent {

    override val dataModule = module {
        single { AchievementMapper() }
        single { RpgMapper() }
        single<RpgRepository> {
            RpgRepositoryImpl(rpgApi = get(), rpgMapper = get(), achievementMapper = get())
        }
        single<RpgApi> { ServiceFactory.createService() }
    }

    override val domainModule = module {
        factory<GetRpgsUseCase> { GetRpgsUseCaseImpl(rpgRepository = get()) }
    }

    override val presentationModule = module {
        single { RpgViewMapper() }
        single { HomeViewModel(getRpgsUseCase = get(), rpgMapper = get()) }
    }

    override val navigationModule = module { }
}
