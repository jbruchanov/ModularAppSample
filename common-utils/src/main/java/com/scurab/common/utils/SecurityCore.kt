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

@Component(modules = [SecurityCoreModule::class])
interface SecurityCoreComponent {
    fun provideSecurityCore(): SecurityCore
}

@Module
open class SecurityCoreModule {

    @Provides
    open fun provideSecurityCore(): SecurityCore {
        TODO()
    }
}

interface HasSecurityCoreComponent {
    val securityCoreComponent: SecurityCoreComponent
}