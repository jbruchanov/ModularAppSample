package com.scurab.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.scurab.common.ui.BaseActivity

abstract class BaseLoginActivity : BaseActivity() {

    protected class BaseLoginActivityViewHolder {
        @BindView(R2.id.login_title)//works
        lateinit var title: TextView

        @OnClick(R2.id.login_continue)//doesn't work
        fun onLoginContinueClick() {
            BaseLoginActivity@ this.onLoginContinueClick()
        }
    }

    protected val baseLoginActivityViewHolder by lazy { BaseLoginActivityViewHolder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        View.inflate(this, R.layout.activity_login, baseActivityViewHolder.fragmentContainer)

        //disabled, as R2 refs not working
        //ButterKnife.bind(baseLoginActivityViewHolder, this)

        baseLoginActivityViewHolder.title = findViewById(R.id.login_title)
        baseLoginActivityViewHolder.title.text = this::class.java.name.toString()
        findViewById<View>(R.id.login_continue).setOnClickListener {
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
