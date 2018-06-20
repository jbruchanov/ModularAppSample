package com.scurab.modularapp

import android.app.Application
import android.content.Context
import com.scurab.common.utils.*
import com.scurab.model.Anonymous
import com.scurab.model.ToothpickScopes
import com.scurab.model.User
import com.scurab.model.UserUpdateListener
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator
import javax.inject.Inject
import kotlin.properties.Delegates

abstract class BaseApp : Application(),
        ComponentProvider,
        UserUpdateListener {

    @Inject
    lateinit var core: AppCore

    //region Dagger
    abstract val appComponent: AppComponent

    private var _userComponent: UserComponent by Delegates.notNull()

    val userComponent: UserComponent
        get() = _userComponent
    //endregion

    //region Toothpick
    abstract val appScope: Scope
    private lateinit var userScope: Scope
    //endregion Toothpick

    override fun onCreate() {
        super.onCreate()

        Toothpick.setConfiguration(
                Configuration.forDevelopment()
                        .disableReflection()
                        .preventMultipleRootScopes())


        FactoryRegistryLocator.setRootRegistry(com.scurab.modularapp.FactoryRegistry())
        MemberInjectorRegistryLocator.setRootRegistry(com.scurab.modularapp.MemberInjectorRegistry())

        if (Config.useDagger) {
            appComponent.inject(this)
        } else {
            Toothpick.inject(this, appScope)
        }
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
        if(Config.useDagger) {
            _userComponent = DaggerUserComponent
                    .builder()
                    .appComponent(appComponent)
                    .userModule(UserModule(user))
                    .build()
        } else {
            if (this::userScope.isInitialized) {
                Toothpick.closeScope(ToothpickScopes.user)
            }
            userScope = Toothpick.openScopes(ToothpickScopes.app, ToothpickScopes.user)
                    .apply {
                        bindScopeAnnotation(PerUser::class.java)
                        installModules(object : Module() {
                            init {
                                bind(User::class.java).toInstance(user)
                            }
                        })
                    }
        }
    }
}

fun Context.app(): BaseApp {
    return this.applicationContext as BaseApp
}