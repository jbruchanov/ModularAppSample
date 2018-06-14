package com.scurab.modularapp.retail

import com.scurab.modularapp.BaseApp
import com.scurab.modularapp.AppComponent

class RetailApp : BaseApp() {

    override val appComponent: AppComponent = DaggerRetailAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
}