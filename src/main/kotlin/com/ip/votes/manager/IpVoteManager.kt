package com.ip.votes.manager

import com.ip.votes.api.ProxyApi
import com.ip.votes.dto.URLDto
import com.ip.votes.services.AppVoteService
import org.springframework.stereotype.Component

@Component
class IpVoteManager(private val appVoteServices: List<AppVoteService>, private val proxyApi: ProxyApi) {

    var count = 0

    fun run() {
        val proxy = proxyApi.findFirstNotUsedWithPortHTTP().execute().body()

        if (proxy == null) {
            count++
            if (count < 6) println("_-¯-_-¯-_-¯-_-NO MORE PROXIES BRO-_-¯-_-¯-_-¯-_")
            return
        }

        proxyApi.updateUsedProxy(URLDto(proxy.url)).execute().body()
        appVoteServices.parallelStream().forEach { it.vote(proxy) }
    }
}