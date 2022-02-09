package com.ip.votes.manager

import org.springframework.stereotype.Component
import com.ip.votes.services.Top100VoteAppService
import com.ip.votes.services.Top100VoteService

@Component
class IpVoteManager(private val top100VoteAppService: Top100VoteAppService, private val top100VoteService: Top100VoteService) {

    fun run() {
        val noMoreProxies = top100VoteAppService.run()
        if (noMoreProxies) top100VoteService.run()
    }
}