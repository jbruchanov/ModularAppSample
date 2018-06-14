package com.scurab.login

import com.scurab.common.utils.IComponent
import dagger.Component
import dagger.Module
import dagger.Provides

interface LoginNavigation {
    fun openLoginScreen()
    fun openHomeScreen()
}


@Component(modules = [LoginNavigationModule::class])
interface LoginNavigationComponent : IComponent {

    fun providesLoginNavigation(): LoginNavigation
}

@Module
open class LoginNavigationModule {

    @Provides
    open fun provideLoginNavigation(): LoginNavigation {
        TODO()
    }
}