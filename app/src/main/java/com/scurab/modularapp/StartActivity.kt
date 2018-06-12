package com.scurab.modularapp

import android.os.Bundle
import com.scurab.common.ui.BaseActivity
import com.scurab.network.RestAPI
import javax.inject.Inject

class StartActivity : BaseActivity() {

    @Inject
    lateinit var serverAPI: RestAPI

    @Inject
    lateinit var core: Core

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "StartActivity"

        app().appComponent.inject(this)
        serverAPI.toString()
    }
}