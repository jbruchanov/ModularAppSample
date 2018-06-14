package com.scurab.modularapp

import com.scurab.common.utils.SecurityCoreComponent
import com.scurab.login.LoginNavigationComponent
import com.scurab.network.NetworkComponent
import com.scurab.network.RestAPI

interface AppComponent :
        LoginNavigationComponent,
        SecurityCoreComponent,
        NetworkComponent {
    fun inject(startActivity: StartActivity)
    fun inject(app: BaseApp)

    fun provideAPI(): RestAPI
}