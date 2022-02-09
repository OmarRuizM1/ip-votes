package com.ip.votes.api

import com.ip.votes.dto.CoinTopListRequest
import com.ip.votes.dto.CoinTopListResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CoinTopListApi {

    @POST("vote/5050")
    fun singleVote(@Body coinTopListRequest: CoinTopListRequest): Call<CoinTopListResponse>
}