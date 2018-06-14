package com.scurab.network

import com.scurab.common.utils.*
import com.scurab.model.Arrangement
import com.scurab.model.Empty
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@PerApp
@Component(modules = [SecurityCoreModule::class, NetworkModule::class])
interface NetworkComponent : IComponent {
    fun provideServerAPI(): RestAPI
}

@Module
class NetworkModule {

    @PerApp
    @Provides
    fun provideServerAPI(securityCore: SecurityCore): RestAPI {
        securityCore.toString()
        return object : RestAPI {
            override fun login(username: String, password: String): Observable<Empty> {
                return Observable.empty<Empty>()
            }

            override fun getArrangements(): Observable<List<Arrangement>> {
                return Observable.empty<List<Arrangement>>()
            }
        }
    }
}