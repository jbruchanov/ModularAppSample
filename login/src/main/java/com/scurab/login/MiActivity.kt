package com.scurab.login

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.ComponentProvider
import com.scurab.common.utils.Config
import com.scurab.common.utils.SecurityCore
import com.scurab.model.ToothpickScopes
import com.scurab.model.User
import com.scurab.model.UserUpdateListener
import javax.inject.Inject

class MiActivity : BaseActivity() {

    @Inject
    lateinit var loginNavigation: LoginNavigation

    @Inject
    lateinit var securityCore: SecurityCore

    @Inject
    lateinit var user: User

    override val toothpickScopes: Array<Any> = arrayOf(ToothpickScopes.app, ToothpickScopes.user, this::class.java.name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Config.useDagger) {
            val componentProvider = applicationContext as ComponentProvider
            DaggerLoginComponent
                    .builder()
                    .securityCoreProvider(componentProvider.getProvider())
                    .loginNavigationProvider(componentProvider.getProvider())
                    .userProvider(componentProvider.getProvider())
                    .build()
                    .inject(this)
        } //else inject()


        Button(this).apply {
            setText(R.string.mi_continue)
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            fragmentContainer.addView(this)
            setOnClickListener {
                (application as UserUpdateListener).onUpdateUser(User(1, "Joe", "Smith"))
                loginNavigation.openHomeScreen()
                finish()
            }
        }
    }
}