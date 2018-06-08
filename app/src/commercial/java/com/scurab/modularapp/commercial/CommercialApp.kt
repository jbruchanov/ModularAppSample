package com.scurab.modularapp.commercial

import com.scurab.modularapp.BaseApp
import com.scurab.modularapp.AppComponent

class CommercialApp : BaseApp() {
    override val appComponent: AppComponent
        get() = DaggerCommercialAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

}