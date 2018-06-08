package com.scurab.network.dto

import com.google.gson.annotations.SerializedName
import com.scurab.model.Arrangement

internal class ArrangementDTO(
        @SerializedName("id")
        val id: Long,
        @SerializedName("name")
        val name: String
) {
    fun toArrangment(): Arrangement {
        return Arrangement(id, name)
    }
}