package com.scurab.login

import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.scurab.common.ui.BaseActivity

abstract class BaseLoginActivity : BaseActivity() {

    @BindView(R2.id.login_title)
    lateinit var title: TextView

    protected class BaseLoginActivityViewHolder {
        @BindView(R2.id.login_title)//works
        lateinit var title: TextView

        @OnClick(R2.id.login_continue)//doesn't work
        fun onLoginContinueClick() {
            BaseLoginActivity@this.onLoginContinueClick()
        }
    }

    protected val baseLoginActivityViewHolder by lazy {BaseLoginActivityViewHolder()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        View.inflate(this, R.layout.activity_login, baseActivityViewHolder.fragmentContainer)

        ButterKnife.bind(baseLoginActivityViewHolder, this)
        title.text = this::class.java.name.toString()

        title = findViewById(R.id.login_title)
        findViewById<View>(R.id.login_continue).setOnClickListener {
            onLoginContinueClick()
        }
    }

    fun onLoginContinueClick() {
        abstractCommonStuff()
        commonStuff()
    }

    fun commonStuff() {

    }

    abstract fun abstractCommonStuff()
}
