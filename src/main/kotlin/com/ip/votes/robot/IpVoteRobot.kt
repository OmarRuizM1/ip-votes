package com.ip.votes.robot

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import com.ip.votes.manager.IpVoteManager

@Component
class IpVoteRobot(private val ipVoteManager: IpVoteManager) {

    @Scheduled(fixedRate = 3000)
    fun run (){
        ipVoteManager.run()
    }
}