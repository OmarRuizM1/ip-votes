package com.ip.votes.manager

import com.ip.votes.api.ProxyApi
import com.ip.votes.dto.URLDto
import com.ip.votes.services.AppVoteService
import org.springframework.stereotype.Component

@Component
class IpVoteManager(private val appVoteServices: List<AppVoteService>, private val proxyApi: ProxyApi) {

    fun run() {
        val proxies = proxyApi.findAllNotUsed().execute().body()

        if (proxies.isNullOrEmpty()) {
            println("No More Proxies Bro")
            return
        }
        val proxy = proxies.first()!!
//        println("Trying Request With: ${proxy.url}")
        proxyApi.updateUsedProxy(URLDto(proxy.url)).execute().body()
        appVoteServices.parallelStream().forEach { it.vote(proxy) }
    }
}