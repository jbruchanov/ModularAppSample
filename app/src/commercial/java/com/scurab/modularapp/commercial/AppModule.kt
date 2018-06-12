package com.scurab.modularapp.commercial

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: CommercialApp) {

    @Provides
    fun app(): CommercialApp {
        return app
    }
}