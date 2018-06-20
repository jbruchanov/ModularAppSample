package com.scurab.network

import com.scurab.common.utils.*
import com.scurab.model.Empty
import com.scurab.network.dto.ArrangementDTO
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@PerApp
@Component(dependencies = [SecurityCoreProvider::class], modules = [NetworkModule::class])
interface NetworkComponent : IComponent {
    fun provideServerAPI(): RestAPI
}

@Module
class NetworkModule {

    @PerApp
    @Provides
    fun provideServerAPI(securityCore: SecurityCore): RestAPI {
        securityCore.toString()
        return ServerAPI(object : RetrofitApi {
            override fun login(username: String, password: String): Observable<Empty> {
                return Observable.empty<Empty>()
            }

            override fun getArrangements(): Observable<List<ArrangementDTO>> {
                return Observable.empty<List<ArrangementDTO>>()
            }
        })
    }
}