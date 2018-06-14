package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.ComponentProvider
import com.scurab.common.utils.IComponent
import com.scurab.common.utils.isValidPassCode
import javax.inject.Inject

abstract class BaseApp : Application(),
        ComponentProvider {

    @Inject
    lateinit var core: AppCore

    abstract val appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        core.toString().isValidPassCode()
    }

    override fun <T : IComponent> provideComponent(): T {
        return appComponent as T
    }
}

fun Context.app(): BaseApp {
    return this.applicationContext as BaseApp
}