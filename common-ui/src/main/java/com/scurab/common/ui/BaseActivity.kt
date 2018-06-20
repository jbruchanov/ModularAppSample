package com.scurab.common.ui

import android.os.Bundle
import android.os.UserHandle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.scurab.common.utils.isValidPassCode
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    internal lateinit var buildConfigWrapper: BuildConfigWrapper

    protected val fragmentContainer: ViewGroup
        get() = fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)

        DaggerCommonUiComponent
                .builder()
                .build()
                .inject(this)

        fragment_container.toString()
        buildConfigWrapper.toString()
        "".isValidPassCode()
    }
}