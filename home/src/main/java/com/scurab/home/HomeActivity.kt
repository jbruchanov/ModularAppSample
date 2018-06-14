package com.scurab.home

import android.os.Bundle
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.ComponentProvider
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    internal lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DaggerHomeComponent
                .builder()
                .networkComponent((applicationContext as ComponentProvider).provideComponent())
                .build()
                .inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}
