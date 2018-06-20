package com.scurab.modularapp

import com.scurab.common.utils.PerUser
import com.scurab.common.utils.SecurityCoreProvider
import com.scurab.login.LoginNavigationProvider
import com.scurab.model.User
import com.scurab.model.UserProvider
import com.scurab.network.NetworkComponent
import com.scurab.network.repository.ArrangementsRepositoryProvider
import dagger.Component
import dagger.Module
import dagger.Provides

interface AppComponent :
        LoginNavigationProvider,
        SecurityCoreProvider,
        NetworkComponent {

    fun inject(startActivity: StartActivity)
    fun inject(app: BaseApp)
}

@PerUser
@Component(dependencies = [AppComponent::class], modules = [UserModule::class])
interface UserComponent : UserProvider,
        AppComponent,
        ArrangementsRepositoryProvider {
}

@Module
class UserModule(var user: User) {

    @PerUser
    @Provides
    fun provideUser(): User {
        return user
    }
}