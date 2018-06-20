package com.scurab.network.repository

import com.scurab.common.utils.IProvider
import com.scurab.common.utils.PerUser
import com.scurab.model.Arrangement
import com.scurab.model.User
import javax.inject.Inject

@PerUser
class ArrangementsRepository @Inject constructor() {

    val arrangements = mutableListOf<Arrangement>()
}

interface ArrangementsRepositoryProvider : IProvider {
    fun getArrangementsRepository() : ArrangementsRepository
}