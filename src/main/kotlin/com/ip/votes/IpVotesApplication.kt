package com.ip.votes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class Top100VotesApplication

fun main(args: Array<String>) {
	runApplication<Top100VotesApplication>(*args)
}
