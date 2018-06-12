package com.scurab.common.ui

import dagger.Component

@Component
interface CommonUiComponent {
    fun inject(baseActivity: BaseActivity)
}