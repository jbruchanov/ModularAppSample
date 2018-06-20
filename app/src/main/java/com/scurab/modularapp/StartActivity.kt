package com.scurab.modularapp

import android.os.Bundle
import android.widget.TextView
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.Config
import com.scurab.login.LoginNavigation
import com.scurab.model.ToothpickScopes
import com.scurab.network.RestAPI
import javax.inject.Inject

class StartActivity : BaseActivity() {

    @Inject
    lateinit var serverAPI: RestAPI

    @Inject
    lateinit var core: AppCore

    @Inject
    lateinit var loginNavigation: LoginNavigation

    override val toothpickScopes: Array<Any> = arrayOf(ToothpickScopes.app, *super.toothpickScopes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "StartActivity"

        if (Config.useDagger) {
            app().appComponent.inject(this)
        } //else inject()

        serverAPI.toString()

        TextView(this).apply {
            setText(R.string.start_will_redirect_in_3_secs)
            fragmentContainer.addView(this)
        }
    }

    private val delayedStartAction = Runnable {
        loginNavigation.openLoginScreen()
        finish()
    }

    override fun onResume() {
        super.onResume()
        window.decorView.postDelayed(delayedStartAction, 3000)
    }

    override fun onPause() {
        super.onPause()
        window.decorView.removeCallbacks(delayedStartAction)
    }
}