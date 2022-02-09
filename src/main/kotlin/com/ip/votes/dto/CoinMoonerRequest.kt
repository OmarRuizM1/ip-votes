package com.ip.votes.dto

data class Variables(val coinId: String)
data class CoinMoonerRequest(
    val operationName: String = "UpvoteCoin",
    val query: String = "mutation UpvoteCoin(\$coinId: String!, \$captcha: String) {\n upvoteCoin(coinId: \$coinId, captcha: \$captcha)\n}\n",
    val variables: Variables = Variables("12121")
)


