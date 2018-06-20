package com.scurab.common.utils

interface IComponent
interface IProvider

interface ComponentProvider {
    fun <T : IComponent> getComponent(): T
    fun <T : IProvider> getProvider(): T
}