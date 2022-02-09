package com.ip.votes.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.ip.votes.manager.IpVoteManager

@RestController
@RequestMapping("/vote")
class IpVotesController(private val ipVoteManager: IpVoteManager) {

    @GetMapping
    fun runOnce() {
        return ipVoteManager.run()
    }
}