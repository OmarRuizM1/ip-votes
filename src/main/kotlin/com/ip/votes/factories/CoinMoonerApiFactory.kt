package com.ip.votes.factories

import com.google.gson.GsonBuilder
import com.ip.votes.api.CoinMoonerApi
import com.ip.votes.dto.Proxy
import java.net.InetSocketAddress
import okhttp3.OkHttpClient
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component
class CoinMoonerApiFactory {

    private val url = "https://coinmooner.com/"

    fun getApi(proxy: Proxy): CoinMoonerApi {
        return Retrofit.Builder().client(OkHttpClient.Builder().proxy(java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress(proxy.host, proxy.port))).build())
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(CoinMoonerApi::class.java)
    }
}