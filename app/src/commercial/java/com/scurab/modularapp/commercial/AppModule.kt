package com.scurab.modularapp.commercial

import android.content.Intent
import com.scurab.login.LoginNavigation
import com.scurab.login.commercial.LoginActivity
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: CommercialApp) {

    @Provides
    fun app(): CommercialApp {
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