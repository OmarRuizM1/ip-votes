package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class ProxyApp(
    @SerializedName("app")
    val app: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("protocol")
    val protocol: String,
    @SerializedName("host")
    val host: String,
    @SerializedName("port")
    val port: Int,
    @SerializedName("used")
    val used: Boolean
)
