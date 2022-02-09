package com.ip.votes.services

import com.ip.votes.dto.Proxy
import com.ip.votes.dto.Top100VoteRequest
import com.ip.votes.dto.Top100VoteResponse
import com.ip.votes.factories.Top100ApiFactory
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Component
class Top100VoteAppService(private val factory: Top100ApiFactory) : AppVoteService {

    var count = 0
    private val success = "success"
    private val request = Top100VoteRequest()

    override fun vote(proxy: Proxy) {
        val response = factory.getApi(proxy).singleVote(request)

        response.enqueue(object : Callback<Top100VoteResponse?> {
            override fun onResponse(call: Call<Top100VoteResponse?>, response: Response<Top100VoteResponse?>) {
                if (response.isSuccessful) {
                    if (response.body()?._data?.done == success) {
                        count++
                        println("Top100Vote: " + response.body() + " count:" + count + " ${proxy.url}")
                    }
                }
            }

            override fun onFailure(call: Call<Top100VoteResponse?>, t: Throwable) {}
        })
    }
}