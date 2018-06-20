package com.scurab.home

import com.scurab.model.Arrangement
import com.scurab.model.User
import com.scurab.network.RestAPI
import com.scurab.network.repository.ArrangementsRepository
import io.reactivex.Observable
import javax.inject.Inject

internal class HomeUseCase @Inject constructor(private val user: User) {

    @Inject
    internal lateinit var serverAPI: RestAPI

    @Inject
    internal lateinit var rep: ArrangementsRepository

    fun getArrangements(): Observable<List<Arrangement>> {
        return serverAPI.getArrangements()
    }
}