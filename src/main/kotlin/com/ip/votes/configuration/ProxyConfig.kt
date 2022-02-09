package com.ip.votes.configuration

import com.google.gson.GsonBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.ip.votes.api.ProxyApi
import com.ip.votes.api.ProxyAppApi

@Configuration
class ProxyConfig(@Value("\${proxyApiHost}") val proxyApiHost: String) {

    @Bean
    fun getProxyApi(): ProxyApi {
        return Retrofit.Builder()
            .baseUrl(proxyApiHost)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(ProxyApi::class.java)
    }

    @Bean
    fun getProxyAppApi(): ProxyAppApi {
        return Retrofit.Builder()
            .baseUrl(proxyApiHost)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(ProxyAppApi::class.java)
    }
}