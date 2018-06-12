package com.scurab.modularapp

import com.scurab.network.NetworkFactory
import com.scurab.network.RestAPI
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provide(): RestAPI {
        return NetworkFactory.createApi()
    }
}