package com.scurab.modularapp

import android.app.Application
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var core: Core

    override fun onCreate() {
        super.onCreate()

        Toothpick.setConfiguration(
                Configuration.forDevelopment()
                        .disableReflection()
                        .preventMultipleRootScopes())


        FactoryRegistryLocator.setRootRegistry(com.scurab.modularapp.FactoryRegistry())
        MemberInjectorRegistryLocator.setRootRegistry(com.scurab.modularapp.MemberInjectorRegistry())

        DaggerAppComponent.create().inject(this)
        core.toString()
    }
}