package com.scurab.network

import com.scurab.model.Arrangement
import com.scurab.model.Empty
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

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
    fun provideServerAPI(): RestAPI {
        return serverApi
    }
}
