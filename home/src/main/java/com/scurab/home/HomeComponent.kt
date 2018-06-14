package com.scurab.home

import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.PerApp
import com.scurab.network.NetworkComponent
import dagger.Component

@PerActivity
@Component(dependencies = [NetworkComponent::class])
interface HomeComponent {

    fun inject(activity: HomeActivity)
}

