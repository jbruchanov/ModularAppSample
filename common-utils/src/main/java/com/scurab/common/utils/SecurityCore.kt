package com.scurab.common.utils

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

interface SecurityCoreProvider : IProvider {
    fun provideSecurityCore(): SecurityCore
}