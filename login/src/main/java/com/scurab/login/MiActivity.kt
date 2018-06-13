package com.scurab.login

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.scurab.common.ui.BaseActivity
import javax.inject.Inject

internal class MiActivity : BaseActivity() {

    @Inject
    lateinit var loginNavigation: LoginNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Button(this).apply {
            setText(R.string.mi_continue)
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            fragmentContainer.addView(this)
            setOnClickListener {
                loginNavigation.openHomeScreen()
                finish()
            }
        }
    }
}