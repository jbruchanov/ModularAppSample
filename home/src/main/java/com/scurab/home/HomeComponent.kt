package com.scurab.home

import com.scurab.network.NetworkComponent
import dagger.Component

@Component(dependencies = [NetworkComponent::class])
interface HomeComponent {

    fun inject(activity: HomeActivity)
}

