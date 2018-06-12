package com.scurab.modularapp

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(startActivity: StartActivity)
    fun inject(app: App)
}