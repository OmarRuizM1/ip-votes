package com.ip.votes.factories

import com.google.gson.GsonBuilder
import com.ip.votes.api.CoinTopListApi
import com.ip.votes.dto.Proxy
import okhttp3.OkHttpClient
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress

@Component
class CoinTopListApiFactory {

    private val url = "https://cointoplist.net/"

    fun getApi(proxy: Proxy): CoinTopListApi {
        return Retrofit.Builder().client(OkHttpClient.Builder().proxy(java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress(proxy.host, proxy.port))).build())
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(CoinTopListApi::class.java)
    }
}