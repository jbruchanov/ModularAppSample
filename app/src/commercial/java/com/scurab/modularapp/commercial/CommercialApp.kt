package com.scurab.modularapp.commercial

import com.scurab.modularapp.AppComponent
import com.scurab.modularapp.BaseApp

class CommercialApp : BaseApp() {
    override val appComponent: AppComponent
        = DaggerCommercialAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

}