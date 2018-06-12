package com.scurab.modularapp.retail

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: RetailApp) {

    @Provides
    fun app(): RetailApp {
        return app
    }
}