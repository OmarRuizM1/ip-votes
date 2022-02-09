package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class AppDto(
    @SerializedName("app")
    val app: String
)