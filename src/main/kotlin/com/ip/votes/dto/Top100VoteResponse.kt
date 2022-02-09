package com.ip.votes.dto

import com.google.gson.annotations.SerializedName

data class Top100VoteResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("_data")
    val _data: Data
)


