package com.peterkrauz.rpgachievements.navhosts.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseActivity(@LayoutRes val layoutId: Int) : AppCompatActivity() {

    abstract val modules: List<Module>

    override fun onCreate(savedInstanceState: Bundle?) {
        doPreCreation()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        loadKoinModules(modules)
        doPostCreation()
    }

    open fun doPreCreation() {}
    open fun doPostCreation() {}

    // TODO: bind/unbind navigator here, on base activity

    override fun onDestroy() {
        unloadKoinModules(modules)
        super.onDestroy()
    }
}
