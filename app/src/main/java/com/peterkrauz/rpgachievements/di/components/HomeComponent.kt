package com.peterkrauz.rpgachievements.di.components

import android.os.Bundle
import com.peterkrauz.data.ServiceFactory
import com.peterkrauz.data.api.PlayerApi
import com.peterkrauz.data.api.RpgApi
import com.peterkrauz.data.mapper.AchievementMapper
import com.peterkrauz.data.mapper.PlayerMapper
import com.peterkrauz.data.mapper.RpgMapper
import com.peterkrauz.data.repository.PlayerRepositoryImpl
import com.peterkrauz.data.repository.RpgRepositoryImpl
import com.peterkrauz.domain.application.GetPlayerUseCase
import com.peterkrauz.domain.application.GetRpgsUseCase
import com.peterkrauz.domain.application.session.SessionStore
import com.peterkrauz.domain.repository.PlayerRepository
import com.peterkrauz.domain.repository.RpgRepository
import com.peterkrauz.domain.usecase.GetPlayerUseCaseImpl
import com.peterkrauz.domain.usecase.GetRpgsUseCaseImpl
import com.peterkrauz.home.activity.HomeViewModel
import com.peterkrauz.home.model.mapper.RpgViewMapper
import com.peterkrauz.presentation.common_ui.routers.HomeRouter
import com.peterkrauz.rpgachievements.achievements.AchievementsViewModel
import com.peterkrauz.rpgachievements.achievements.model.mapper.AchievementViewMapper
import com.peterkrauz.rpgachievements.di.DIComponent
import com.peterkrauz.rpgachievements.navigator.Navigator
import org.koin.dsl.module

object HomeComponent : DIComponent {

    override val dataModule = module {
        single { AchievementMapper() }
        single { PlayerMapper() }
        single { RpgMapper() }
        single<RpgRepository> {
            RpgRepositoryImpl(rpgApi = get(), rpgMapper = get(), achievementMapper = get())
        }
        single<PlayerRepository> {
            PlayerRepositoryImpl(playerApi = get(), playerMapper = get())
        }
        single<RpgApi> { ServiceFactory.createService() }
        single<PlayerApi> { ServiceFactory.createService() }
    }

    override val domainModule = module {
        factory<GetRpgsUseCase> { GetRpgsUseCaseImpl(rpgRepository = get()) }
        factory<GetPlayerUseCase> { GetPlayerUseCaseImpl(playerRepository = get()) }
    }

    override val presentationModule = module {
        single { RpgViewMapper() }
        single { AchievementViewMapper() }
        single { (store: SessionStore) ->
            HomeViewModel(
                getRpgsUseCase = get(),
                getPlayerUseCase = get(),
                rpgMapper = get(),
                sessionStore = store
            )
        }
        factory { (achievementDetails: Bundle) ->
            AchievementsViewModel(
                achievementDetails = achievementDetails,
                rpgRepository = get(),
                playerRepository = get(),
                mapper = get()
            )
        }

        single<HomeRouter> { Navigator }
    }

    override val navigationModule = module { }
}
