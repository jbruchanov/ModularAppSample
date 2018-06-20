package com.scurab.modularapp.commercial

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

class CommercialApp : BaseApp() {

    private val securityCore = SecurityCore()

    override val appComponent: AppComponent
        = DaggerCommercialAppComponent
                .builder()
                .appModule(AppModule(this, securityCore))
                .build()

    override val appScope: Scope
        = Toothpick
                .openScope(ToothpickScopes.app)
                .apply {
                    bindScopeAnnotation(PerApp::class.java)
                    installModules(object : Module() {
                        init {
                            bind(CommercialApp::class.java).toInstance(this@CommercialApp)
                            bind(LoginNavigation::class.java).toInstance(AppModule(this@CommercialApp, securityCore).provideLoginNavigation())
                            bind(SecurityCore::class.java).toInstance(securityCore)
                            bind(RestAPI::class.java).toInstance(NetworkModule().provideServerAPI(securityCore))
                        }
                    })
                }
}