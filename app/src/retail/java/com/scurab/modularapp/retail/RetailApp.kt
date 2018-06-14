package com.scurab.modularapp.retail

import com.scurab.modularapp.AppComponent
import com.scurab.modularapp.BaseApp

class RetailApp : BaseApp() {

    override val appComponent: AppComponent = DaggerRetailAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
}