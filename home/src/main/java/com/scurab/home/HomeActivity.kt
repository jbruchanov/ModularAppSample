package com.scurab.home

import android.os.Bundle
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.ComponentProvider
import com.scurab.model.User
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    internal lateinit var presenter: HomePresenter

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val componentProvider = applicationContext as ComponentProvider
        DaggerHomeComponent
                .builder()
                .networkComponent(componentProvider.getComponent())
                .userProvider(componentProvider.getProvider())
                .arrangementsRepositoryProvider(componentProvider.getProvider())
                .build()
                .inject(this)

        userName.text = user.toString()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
