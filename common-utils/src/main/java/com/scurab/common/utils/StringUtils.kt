package com.scurab.common.utils

class StringUtils {
    companion object {
        fun isLong(value: String) = value.length > 10
    }
}

fun String.isValidPassCode() = this.length == 8