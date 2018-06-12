package com.scurab.network.dto

import com.google.gson.annotations.SerializedName
import kotlin.properties.Delegates

internal class UserDTO {
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("firstname")
    val firstname: String? = null

    private val _surename by Delegates.notNull<String>()

    @SerializedName("surename")
    val surename: String = _surename
}
