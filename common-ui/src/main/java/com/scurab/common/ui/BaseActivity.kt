package com.scurab.common.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.scurab.common.utils.isValidPassCode
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    internal lateinit var buildConfigWrapper: BuildConfigWrapper

    @BindView(R2.id.fragment_container)
    lateinit var fragmentContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        ButterKnife.bind(this)

        "".isValidPassCode()
    }
}