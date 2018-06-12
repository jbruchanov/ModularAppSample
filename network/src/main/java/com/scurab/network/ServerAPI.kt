package com.scurab.network

import com.scurab.model.Arrangement
import com.scurab.model.Empty
import io.reactivex.Observable

internal open class ServerAPI(private val api: RetrofitApi) : RestAPI {
    override fun login(username: String, password: String): Observable<Empty> {
        return api.login(username, password)
    }

    override fun getArrangements(): Observable<List<Arrangement>> {
        return api
                .getArrangements()
                .map {list ->
                    list.map { it.toArrangment() }
                }
    }
}