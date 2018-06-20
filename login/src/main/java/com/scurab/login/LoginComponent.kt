package com.scurab.login

import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.SecurityCoreProvider
import dagger.Component

@PerActivity
@Component(dependencies = [SecurityCoreProvider::class, LoginNavigationProvider::class])
interface LoginComponent {

    fun inject(miActivity: MiActivity)
}