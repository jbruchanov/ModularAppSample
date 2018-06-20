package com.scurab.login

import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.SecurityCoreProvider
import com.scurab.model.UserProvider
import dagger.Component

@PerActivity
@Component(dependencies = [SecurityCoreProvider::class, LoginNavigationProvider::class, UserProvider::class])
interface LoginComponent {

    fun inject(miActivity: MiActivity)
}