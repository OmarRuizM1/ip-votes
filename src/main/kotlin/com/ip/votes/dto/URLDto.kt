package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class URLDto(
    @SerializedName("url")
    val url: String
)