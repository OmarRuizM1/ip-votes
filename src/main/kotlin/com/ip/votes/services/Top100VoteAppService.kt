package com.ip.votes.services

import java.net.InetSocketAddress
import java.net.Proxy
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.ip.votes.api.ProxyAppApi
import com.ip.votes.configuration.Top100ApiFactory
import com.ip.votes.constants.Top100Constants.Companion.app
import com.ip.votes.constants.Top100Constants.Companion.top100VoteRequest
import com.ip.votes.dto.AppAndUrlRequest
import com.ip.votes.dto.AppDto
import com.ip.votes.dto.Top100VoteResponse

@Component
class Top100VoteAppService(private val top100ApiFactory: Top100ApiFactory, private val proxyAppApi: ProxyAppApi) {

    fun run(): Boolean {
        val responseBody = proxyAppApi.findAllNotUsed(AppDto(app)).execute().body()

        if (responseBody.isNullOrEmpty()) return true

        val proxy = responseBody.first()!!
        println("Trying Request With: ${proxy.url}")
        proxyAppApi.updateUsedProxy(AppAndUrlRequest(app, proxy.url)).execute().body()
        val api = top100ApiFactory.getTop100ApiByProxy(Proxy(Proxy.Type.HTTP, InetSocketAddress(proxy.host, proxy.port)))
        val response = api.singleVote(top100VoteRequest)

        response.enqueue(object : Callback<Top100VoteResponse?> {
            override fun onResponse(call: Call<Top100VoteResponse?>, response: Response<Top100VoteResponse?>) {
                if (response.isSuccessful) {
                    println(response.body())
                } else {
                    println("Request Error :: ${proxy.url} : " + response.errorBody())
                }
            }

            override fun onFailure(call: Call<Top100VoteResponse?>, t: Throwable) {
                println("Network Error :: ${proxy.url}: " + t.localizedMessage)
            }
        })
        return false
    }
}