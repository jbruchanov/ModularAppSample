package com.scurab.modularapp.retail

import com.scurab.common.utils.PerApp
import com.scurab.modularapp.AppComponent
import dagger.Component

@PerApp
@Component(modules = [AppModule::class])
interface RetailAppComponent : AppComponent