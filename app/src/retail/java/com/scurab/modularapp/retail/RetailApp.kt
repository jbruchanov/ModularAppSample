package com.scurab.modularapp.retail

import com.scurab.common.utils.PerApp
import com.scurab.common.utils.SecurityCore
import com.scurab.login.LoginNavigation
import com.scurab.model.ToothpickScopes
import com.scurab.modularapp.AppComponent
import com.scurab.modularapp.BaseApp
import com.scurab.network.NetworkModule
import com.scurab.network.RestAPI
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

class RetailApp : BaseApp() {

    private val securityCore = SecurityCore()

    override val appComponent: AppComponent = DaggerRetailAppComponent
            .builder()
            .appModule(AppModule(this, securityCore))
            .build()

    override val appScope: Scope
        get() = Toothpick
                .openScope(ToothpickScopes.app)
                .apply {
                    bindScopeAnnotation(PerApp::class.java)
                    installModules(object : Module() {
                        init {
                            val securityCore = SecurityCore()
                            bind(RetailApp::class.java).toInstance(this@RetailApp)
                            bind(LoginNavigation::class.java).toInstance(AppModule(this@RetailApp, securityCore).provideLoginNavigation())
                            bind(SecurityCore::class.java).toInstance(securityCore)
                            bind(RestAPI::class.java).toInstance(NetworkModule().provideServerAPI(securityCore))
                        }
                    })
                }
}