package com.ip.votes.api

import com.ip.votes.dto.CoinMoonerRequest
import com.ip.votes.dto.CoinMoonerResponse
import com.ip.votes.dto.CoinTopListRequest
import com.ip.votes.dto.CoinTopListResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CoinMoonerApi {

    @POST("api/voting/")
    fun singleVote(@Body coinMoonerRequest: CoinMoonerRequest): Call<CoinMoonerResponse>
}