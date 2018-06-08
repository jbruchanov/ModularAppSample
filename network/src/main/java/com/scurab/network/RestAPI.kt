package com.scurab.network

import com.scurab.model.Arrangement
import com.scurab.model.Empty
import io.reactivex.Observable

interface RestAPI {

    fun login(username: String, password: String) : Observable<Empty>

    fun getArrangements(): Observable<List<Arrangement>>
}