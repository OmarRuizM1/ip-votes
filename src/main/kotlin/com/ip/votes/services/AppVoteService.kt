package com.ip.votes.services

import com.ip.votes.dto.Proxy

interface AppVoteService {
    fun vote(proxy: Proxy)
}