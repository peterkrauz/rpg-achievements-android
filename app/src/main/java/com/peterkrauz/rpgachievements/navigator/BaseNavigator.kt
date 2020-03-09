package com.peterkrauz.rpgachievements.navigator

import androidx.navigation.NavController

abstract class BaseNavigator {

    protected var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unBind() {
        this.navController = null
    }
}
