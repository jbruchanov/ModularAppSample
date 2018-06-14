package com.scurab.login

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.scurab.common.ui.BaseActivity
import com.scurab.common.utils.HasComponent
import com.scurab.common.utils.HasSecurityCoreComponent
import com.scurab.common.utils.SecurityCore
import javax.inject.Inject

class MiActivity : BaseActivity() {

    @Inject
    lateinit var loginNavigation: LoginNavigation

    @Inject
    lateinit var securityCore: SecurityCore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerLoginComponent
                .builder()
                .securityCoreComponent((application as HasSecurityCoreComponent).securityCoreComponent)
                .loginNavigationComponent((application as HasLoginNavigationComponent).loginNavigationComponent)
                .build()
                .inject(this)


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