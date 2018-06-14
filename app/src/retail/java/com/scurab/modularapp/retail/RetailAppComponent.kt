package com.scurab.modularapp.retail

import com.scurab.modularapp.AppComponent
import dagger.Component

@Component(modules = [AppModule::class])
interface RetailAppComponent : AppComponent