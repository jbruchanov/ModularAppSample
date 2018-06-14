package com.scurab.modularapp.retail

import android.content.Intent
import com.scurab.common.utils.SecurityCore
import com.scurab.home.HomeActivity
import com.scurab.login.LoginNavigation
import com.scurab.login.retail.LoginActivity
import com.scurab.modularapp.BaseAppModule
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: RetailApp) : BaseAppModule(SecurityCore()) {

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
                app.startActivity(Intent(app, HomeActivity::class.java))
            }
        }
    }
}
