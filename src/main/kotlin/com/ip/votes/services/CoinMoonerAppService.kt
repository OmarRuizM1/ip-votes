package com.ip.votes.services

import com.ip.votes.dto.CoinMoonerRequest
import com.ip.votes.dto.CoinMoonerResponse
import com.ip.votes.dto.Proxy
import com.ip.votes.factories.CoinMoonerApiFactory
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Service
class CoinMoonerAppService(private val factory: CoinMoonerApiFactory) : AppVoteService {

    var count = 0
    private val request = CoinMoonerRequest()

    override fun vote(proxy: Proxy) {
        val response = factory.getApi(proxy).singleVote(request)

        response.enqueue(object : Callback<CoinMoonerResponse?> {
            override fun onResponse(call: Call<CoinMoonerResponse?>, response: Response<CoinMoonerResponse?>) {
                if (response.isSuccessful) {
                    if (response.body()?.data != null && response.body()?.data!!.upvoteCoin) {
                        count++
                        println("CoinMooner: " + response.body() + " count:" + count + " ${proxy.url}")
                    }
                }
            }
            override fun onFailure(call: Call<CoinMoonerResponse?>, t: Throwable) {}
        })
    }
}