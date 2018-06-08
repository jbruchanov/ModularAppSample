package com.scurab.common.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import butterknife.BindView
import toothpick.Toothpick
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var buildConfigWrapper: BuildConfigWrapper

    @BindView(R2.id.fragment_container)
    lateinit var fragmentContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val appScope = Toothpick.openScope(BaseActivity::class)
        Toothpick.inject(this, appScope)
    }
}