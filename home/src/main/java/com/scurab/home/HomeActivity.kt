package com.scurab.home

import android.os.Bundle
import com.scurab.common.ui.BaseActivity
import com.scurab.network.HasNetworkComponent
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DaggerHomeComponent
                .builder()
                .networkComponent((applicationContext as HasNetworkComponent).networkComponent)
                .build()
                .inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
