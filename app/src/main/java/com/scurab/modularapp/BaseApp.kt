package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.isValidPassCode
import javax.inject.Inject

abstract class BaseApp : Application() {

    @Inject
    lateinit var core: Core

    abstract val appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        core.toString().isValidPassCode()
    }
}

fun Context.app(): BaseApp {
    return this.applicationContext as BaseApp
}