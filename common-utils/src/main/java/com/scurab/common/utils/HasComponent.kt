package com.scurab.common.utils

interface IComponent

interface ComponentProvider {
    fun <T : IComponent> provideComponent(): T
}