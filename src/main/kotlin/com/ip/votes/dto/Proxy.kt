package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class Proxy(
    @SerializedName("url")
    val url: String,
    @SerializedName("protocol")
    val protocol: String,
    @SerializedName("host")
    val host: String,
    @SerializedName("port")
    val port: Int,
    @SerializedName("used")
    var used: Boolean
) {
    fun toProxyApp(app: String): ProxyApp = ProxyApp(app, this.url, this.protocol, this.host, this.port, this.used)
}
