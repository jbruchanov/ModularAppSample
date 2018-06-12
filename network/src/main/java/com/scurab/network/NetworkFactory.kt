package com.scurab.network

import com.scurab.model.Arrangement
import com.scurab.model.Empty
import io.reactivex.Observable

class NetworkFactory {
    companion object {
        fun createApi(): RestAPI {
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
}