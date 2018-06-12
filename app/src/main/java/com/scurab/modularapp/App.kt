package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.isValidPassCode
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var core: Core

    val appComponent: AppComponent by lazy { DaggerAppComponent.create() }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        core.toString().isValidPassCode()
    }
}

fun Context.app(): App {
    return this.applicationContext as App
}