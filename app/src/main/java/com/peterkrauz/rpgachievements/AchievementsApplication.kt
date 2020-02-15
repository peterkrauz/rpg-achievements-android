package com.peterkrauz.rpgachievements

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class AchievementsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}
