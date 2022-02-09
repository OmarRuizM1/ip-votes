package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class Data2(
    @SerializedName("upvoteCoin")
    val upvoteCoin: Boolean
)

data class CoinMoonerResponse(
    @SerializedName("data")
    val data: Data2
)


