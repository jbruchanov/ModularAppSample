package com.scurab.common.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.scurab.common.utils.Config
import com.scurab.common.utils.PerActivity
import com.scurab.common.utils.isValidPassCode
import kotlinx.android.synthetic.main.activity_base.*
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject
import kotlin.properties.Delegates

open class BaseActivity : AppCompatActivity() {

    @Inject
    internal lateinit var buildConfigWrapper: BuildConfigWrapper

    protected var scope: Scope by Delegates.notNull()

    protected open val toothpickScopes: Array<Any> = arrayOf("App" /*com.scurab.model.ToothpickScopes.app*/, this::class.java.name)

    protected val fragmentContainer: ViewGroup
        get() = fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scope = openScope()

        setContentView(R.layout.activity_base)

        if (Config.useDagger) {
            DaggerCommonUiComponent
                    .builder()
                    .build()
                    .inject(this)
        } else {
            inject(scope)
        }

        fragment_container.toString()
        buildConfigWrapper.toString()
        "".isValidPassCode()
    }

    protected open fun openScope(): Scope {
        return Toothpick.openScopes(*toothpickScopes).apply {
            bindScopeAnnotation(PerActivity::class.java)
        }
    }

    protected open fun inject(scope: Scope) {
        Toothpick.inject(this, scope)
    }

    override fun onDestroy() {
        Toothpick.closeScope(this::class.java.name)
        super.onDestroy()
    }
}