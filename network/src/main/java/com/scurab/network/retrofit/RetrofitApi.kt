package com.scurab.network

import com.scurab.model.Empty
import com.scurab.network.dto.ArrangementDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

internal interface RetrofitApi {

    @POST("login")
    fun login(username: String, password: String): Observable<Empty>

    @GET("arrangements")
    fun getArrangements(): Observable<List<ArrangementDTO>>
}