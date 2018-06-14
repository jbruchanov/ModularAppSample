package com.scurab.modularapp.commercial

import com.scurab.common.utils.PerApp
import com.scurab.modularapp.AppComponent
import dagger.Component

@PerApp
@Component(modules = [AppModule::class])
interface CommercialAppComponent : AppComponent