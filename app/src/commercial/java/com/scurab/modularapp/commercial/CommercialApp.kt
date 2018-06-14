package com.scurab.modularapp.commercial

import com.scurab.modularapp.BaseApp
import com.scurab.modularapp.AppComponent

class CommercialApp : BaseApp() {
    override val appComponent: AppComponent
        = DaggerCommercialAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

}