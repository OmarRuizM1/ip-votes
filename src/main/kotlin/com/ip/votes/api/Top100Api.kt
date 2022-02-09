package com.ip.votes.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.ip.votes.dto.Top100VoteRequest
import com.ip.votes.dto.Top100VoteResponse

interface Top100Api {
    @POST("vote/single")
    fun singleVote(@Body top100VoteRequest: Top100VoteRequest): Call<Top100VoteResponse>
}