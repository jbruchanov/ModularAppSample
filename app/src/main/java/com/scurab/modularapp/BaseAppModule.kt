package com.scurab.modularapp

import com.scurab.common.utils.SecurityCore
import com.scurab.network.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
abstract class BaseAppModule(private val securityCore: SecurityCore) {

    @Provides
    fun provideSecurityCore() : SecurityCore = securityCore
}
