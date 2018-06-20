package com.scurab.home

import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.PerApp
import com.scurab.model.UserProvider
import com.scurab.network.NetworkComponent
import com.scurab.network.repository.ArrangementsRepositoryProvider
import dagger.Component

@PerActivity
@Component(dependencies = [NetworkComponent::class,
    UserProvider::class,
    ArrangementsRepositoryProvider::class])
interface HomeComponent {

    fun inject(activity: HomeActivity)
}

