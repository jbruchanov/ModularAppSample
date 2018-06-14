package com.scurab.login

import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.SecurityCoreComponent
import dagger.Component

@PerActivity
@Component(dependencies = [SecurityCoreComponent::class, LoginNavigationComponent::class])
interface LoginComponent {

    fun inject(miActivity: MiActivity)
}