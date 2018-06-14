package com.scurab.common.utils

interface IComponent

interface HasComponent<out T : IComponent> {
    val component: T
}