package com.scurab.home

import javax.inject.Inject


class HomePresenter @Inject constructor() {

    @Inject
    lateinit var homeUseCase: HomeUseCase

    fun onResume() {
        homeUseCase.getArrangements()
    }
}