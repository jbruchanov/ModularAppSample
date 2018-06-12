package com.scurab.modularapp.commercial

import com.scurab.modularapp.AppComponent
import com.scurab.network.NetworkModule
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface CommercialAppComponent : AppComponent