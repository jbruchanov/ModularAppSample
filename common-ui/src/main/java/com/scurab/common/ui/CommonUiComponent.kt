package com.scurab.common.ui

import dagger.Component

@Component
internal interface CommonUiComponent {
    fun inject(baseActivity: BaseActivity)
}