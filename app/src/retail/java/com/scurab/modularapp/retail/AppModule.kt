package com.scurab.modularapp.retail

import android.content.Intent
import com.scurab.login.LoginNavigation
import com.scurab.login.retail.LoginActivity
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: RetailApp) {

    @Provides
    fun app(): RetailApp {
        return app
    }

    @Provides
    fun provideLoginNavigation(): LoginNavigation {
        return object : LoginNavigation {
            override fun openLoginScreen() {
                app.startActivity(Intent(app, LoginActivity::class.java))
            }

            override fun openHomeScreen() {
                TODO()
            }
        }
    }
}