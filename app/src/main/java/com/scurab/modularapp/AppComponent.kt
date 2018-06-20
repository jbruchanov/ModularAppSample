package com.scurab.modularapp

import com.scurab.common.utils.PerUser
import com.scurab.common.utils.SecurityCoreProvider
import com.scurab.login.LoginNavigationProvider
import com.scurab.network.NetworkComponent
import dagger.Component

interface AppComponent :
        LoginNavigationProvider,
        SecurityCoreProvider,
        NetworkComponent {

    fun inject(startActivity: StartActivity)
    fun inject(app: BaseApp)

}
}