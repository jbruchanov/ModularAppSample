package com.scurab.login

import dagger.Component
import dagger.Module
import dagger.Provides

interface LoginNavigation {
    fun openLoginScreen()
    fun openHomeScreen()
}


@Component(modules = [LoginNavigationModule::class])
interface LoginNavigationComponent {

    fun providesLoginNavigation() : LoginNavigation
}

@Module
open class LoginNavigationModule {

    @Provides
    open fun provideLoginNavigation(): LoginNavigation {
        TODO()
    }
}

interface HasLoginNavigationComponent {
    val loginNavigationComponent: LoginNavigationComponent
}