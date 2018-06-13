package com.scurab.common.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.scurab.common.utils.isValidPassCode
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_base.*

open class BaseActivity : AppCompatActivity() {

    @Inject
    internal lateinit var buildConfigWrapper: BuildConfigWrapper

    protected val fragmentContainer: ViewGroup
        get() = fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)

        DaggerCommonUiComponent.create().inject(this)

        fragment_container.toString()
        buildConfigWrapper.toString()
        "".isValidPassCode()
    }
}