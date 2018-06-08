package com.scurab.common.ui

//import dagger.Module
//import dagger.Provides

//@Module
open class ComponentUiModule {

//    @Provides
    fun provideBuildConfigWrapper(): BuildConfigWrapper {
        return BuildConfigWrapper()
    }
}