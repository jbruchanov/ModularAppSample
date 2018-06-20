package com.scurab.login

import com.scurab.common.utils.IProvider

interface LoginNavigation {
    fun openLoginScreen()
    fun openHomeScreen()
}

interface LoginNavigationProvider : IProvider {

    fun providesLoginNavigation(): LoginNavigation
}