package com.scurab.common.utils

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApp

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerUser