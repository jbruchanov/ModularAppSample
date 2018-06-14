package com.scurab.network

import com.scurab.common.utils.SecurityCore
import com.scurab.common.utils.SecurityCoreComponent
import com.scurab.model.Arrangement
import com.scurab.model.Empty
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Component(dependencies = [SecurityCoreComponent::class], modules = [NetworkModule::class])
interface NetworkComponent {
    fun provideServerAPI(): RestAPI
}

@Module
class NetworkModule {

    private val serverApi by lazy {
        object : RestAPI {
            override fun login(username: String, password: String): Observable<Empty> {
                return Observable.empty<Empty>()
            }

            override fun getArrangements(): Observable<List<Arrangement>> {
                return Observable.empty<List<Arrangement>>()
            }
        }
    }

    @Provides
    fun provideServerAPI(securityCore: SecurityCore): RestAPI {
        securityCore.toString()
        return serverApi
    }
}

interface HasNetworkComponent {
    val networkComponent: NetworkComponent
}