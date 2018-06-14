package com.scurab.home

import com.scurab.model.Arrangement
import com.scurab.network.RestAPI
import io.reactivex.Observable
import javax.inject.Inject

class HomeUseCase @Inject constructor() {

    @Inject
    internal lateinit var serverAPI: RestAPI

    fun getArrangements(): Observable<List<Arrangement>> {
        return serverAPI.getArrangements()
    }
}