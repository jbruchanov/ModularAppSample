package com.scurab.modularapp.retail

import android.content.Intent
import com.scurab.common.utils.PerApp
import com.scurab.common.utils.SecurityCore
import com.scurab.home.HomeActivity
import com.scurab.login.LoginNavigation
import com.scurab.modularapp.BaseAppModule
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: RetailApp, securityCore: SecurityCore) : BaseAppModule(securityCore) {

    @Provides
    fun app(): RetailApp {
        return app
    }

    @PerApp
    @Provides
    fun provideLoginNavigation(): LoginNavigation {
        return object : LoginNavigation {
            override fun openLoginScreen() {
                app.startActivity(Intent(app, com.scurab.login.retail.LoginActivity::class.java))
            }

            override fun openHomeScreen() {
                app.startActivity(Intent(app, HomeActivity::class.java))
            }
        }
    }
}
