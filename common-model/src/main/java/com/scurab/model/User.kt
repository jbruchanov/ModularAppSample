package com.scurab.model

import com.scurab.common.utils.IProvider

open class User(
        val id: Int,
        val firstname: String,
        val surename: String
) {
    override fun toString(): String {
        return "[$id] - $firstname $surename"
    }
}

object Anonymous : User(0, "Anonymous", "Unsigned")

interface UserUpdateListener {
    fun onUpdateUser(user: User)
}

interface UserProvider : IProvider {
    fun provideUser(): User
}