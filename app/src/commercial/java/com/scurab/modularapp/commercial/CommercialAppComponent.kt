package com.scurab.modularapp.commercial

import com.scurab.modularapp.AppComponent
import dagger.Component

@Component(modules = [AppModule::class])
interface CommercialAppComponent : AppComponent