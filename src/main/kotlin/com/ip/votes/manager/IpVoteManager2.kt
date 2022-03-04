package com.ip.votes.manager

import com.ip.votes.api.ProxyApi
import com.ip.votes.dto.CoinMoonerResponse
import com.ip.votes.dto.URLDto
import com.ip.votes.services.AppVoteService
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Component
class IpVoteManager2(private val appVoteServices: List<AppVoteService>, private val proxyApi: ProxyApi) : VoteManager {

    override fun run() {
        proxyApi.findAllNotUsedWithProtocolHTTP().execute().body()?.forEach {
            if (it == null) {
                println("$it is null")
            } else {
                proxyApi.updateUsedProxy(URLDto(it.url)).execute().body()
                appVoteServices.parallelStream().forEach { x -> x.vote(it) }
                Thread.sleep(2000)
            }
        }
        println("_-¯-_-¯-_-¯-_-NO MORE PROXIES BRO-_-¯-_-¯-_-¯-_")

        proxyApi.bulkUpdateUsedFalse().enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) {
                    println("_-¯-_-¯-_-¯-_-SUCCESS -> EXECUTED BULK UPDATE-_-¯-_-¯-_-¯-_")
                }
            }
            override fun onFailure(call: Call<Void?>, t: Throwable) {
                println("_-¯-_-¯-_-¯-_- ERROR -> EXECUTED BULK UPDATE-_-¯-_-¯-_-¯-_")
                println(t.message)
            }
        })

    }
}