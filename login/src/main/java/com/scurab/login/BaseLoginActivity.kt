package com.scurab.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.scurab.common.ui.BaseActivity
import com.scurab.model.User
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

abstract class BaseLoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //usage of fragment_container from BaseActivity doesn't work
        //presumably because we are in different project-module
        View.inflate(this, R.layout.activity_login, fragmentContainer)

        //view with id title no accessible here as `title` as BaseLoginActivity has title property
        login_title.text = this::class.java.name.toString()
        login_continue.setOnClickListener {
            onLoginContinueClick()
        }
    }

    fun onLoginContinueClick() {
        abstractCommonStuff()
        commonStuff()
        startActivity(Intent(this, MiActivity::class.java))
    }

    fun commonStuff() {

    }

    abstract fun abstractCommonStuff()
}
