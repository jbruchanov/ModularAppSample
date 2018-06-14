package com.scurab.common.utils

import dagger.Component
import dagger.Module
import dagger.Provides

class SecurityCore {

    init {
        instances++
        if (instances > 1) {
            throw IllegalStateException("SecurityCore instance:$instances")
        }
    }

    companion object {
        private var instances = 0
    }
}

@PerApp
@Component(modules = [SecurityCoreModule::class])
interface SecurityCoreComponent : IComponent {
    fun provideSecurityCore(): SecurityCore
}

@Module
open class SecurityCoreModule {

    @Provides
    open fun provideSecurityCore(): SecurityCore {
        TODO("This is created in application object, must be overridden")
    }
}