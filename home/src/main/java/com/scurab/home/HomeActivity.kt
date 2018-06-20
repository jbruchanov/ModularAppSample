package com.scurab.home

import android.os.Bundle
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.ComponentProvider
import com.scurab.common.utils.Config
import com.scurab.common.utils.PerActivity
import com.scurab.model.ToothpickScopes
import com.scurab.model.User
import kotlinx.android.synthetic.main.activity_home.*
import toothpick.Scope
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    internal lateinit var presenter: HomePresenter

    @Inject
    lateinit var user: User

    override val toothpickScopes: Array<Any> = arrayOf(ToothpickScopes.app, ToothpickScopes.user, this::class.java.name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (Config.useDagger) {
            val componentProvider = applicationContext as ComponentProvider
            DaggerHomeComponent
                    .builder()
                    .networkComponent(componentProvider.getComponent())
                    .userProvider(componentProvider.getProvider())
                    .arrangementsRepositoryProvider(componentProvider.getProvider())
                    .build()
                    .inject(this)

            userName.text = user.toString()
        } //else inject
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
