package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.ComponentProvider
import com.scurab.common.utils.IComponent
import com.scurab.common.utils.IProvider
import com.scurab.common.utils.isValidPassCode
import com.scurab.model.Anonymous
import com.scurab.model.User
import com.scurab.model.UserUpdateListener
import javax.inject.Inject
import kotlin.properties.Delegates

abstract class BaseApp : Application(),
        ComponentProvider,
        UserUpdateListener {

    @Inject
    lateinit var core: AppCore

    abstract val appComponent: AppComponent

    private var _userComponent: UserComponent by Delegates.notNull()

    val userComponent: UserComponent
        get() = _userComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
        onUpdateUser(Anonymous)
        core.toString().isValidPassCode()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : IComponent> getComponent(): T {
        return userComponent as T
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : IProvider> getProvider(): T {
        return userComponent as T
    }

    override fun onUpdateUser(user: User) {
        _userComponent = DaggerUserComponent
                .builder()
                .appComponent(appComponent)
                .userModule(UserModule(user))
                .build()
    }
}

fun Context.app(): BaseApp {
    return this.applicationContext as BaseApp
}