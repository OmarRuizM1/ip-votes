package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class CoinTopListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("status")
    val status: String
)


