package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.HasSecurityCoreComponent
import com.scurab.common.utils.SecurityCoreComponent
import com.scurab.common.utils.isValidPassCode
import com.scurab.login.HasLoginNavigationComponent
import com.scurab.login.LoginNavigationComponent
import com.scurab.network.HasNetworkComponent
import com.scurab.network.NetworkComponent
import javax.inject.Inject

abstract class BaseApp : Application(),
        HasLoginNavigationComponent,
        HasSecurityCoreComponent,
        HasNetworkComponent {

    @Inject
    lateinit var core: AppCore

    abstract val appComponent: AppComponent

    override val loginNavigationComponent: LoginNavigationComponent get() = appComponent
    override val securityCoreComponent: SecurityCoreComponent get() = appComponent
    override val networkComponent: NetworkComponent get() = appComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        core.toString().isValidPassCode()
    }
}

fun Context.app(): BaseApp {
    return this.applicationContext as BaseApp
}