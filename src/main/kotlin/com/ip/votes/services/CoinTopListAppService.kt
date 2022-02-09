package com.ip.votes.services

import com.ip.votes.dto.CoinTopListRequest
import com.ip.votes.dto.CoinTopListResponse
import com.ip.votes.dto.Proxy
import com.ip.votes.factories.CoinTopListApiFactory
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Component
class CoinTopListAppService(private val factory: CoinTopListApiFactory) : AppVoteService {

    var count = 0
    private val request = CoinTopListRequest()
    private val success = "1"

    override fun vote(proxy: Proxy) {
        val response = factory.getApi(proxy).singleVote(request)

        response.enqueue(object : Callback<CoinTopListResponse?> {
            override fun onResponse(call: Call<CoinTopListResponse?>, response: Response<CoinTopListResponse?>) {
                if (response.isSuccessful) {
                    if (response.body()?.status == success) {
                        count++
                        println("CoinTop: " + response.body() + " count:" + count + " ${proxy.url}")
                    }
                }
            }

            override fun onFailure(call: Call<CoinTopListResponse?>, t: Throwable) {}
        })
    }
}