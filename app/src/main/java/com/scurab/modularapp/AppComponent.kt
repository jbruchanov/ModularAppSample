package com.scurab.modularapp

import com.scurab.network.RestAPI

interface AppComponent {
    fun inject(startActivity: StartActivity)
    fun inject(app: BaseApp)

    fun provideAPI() : RestAPI
}