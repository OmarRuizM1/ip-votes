package com.ip.votes.configuration

import com.google.gson.GsonBuilder
import java.net.Proxy
import okhttp3.OkHttpClient
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.ip.votes.api.Top100Api

@Component
class Top100ApiFactory {

    fun getTop100ApiByProxy(proxy: Proxy): Top100Api {
        return Retrofit.Builder().client(OkHttpClient.Builder().proxy(proxy).build())
            .baseUrl(API_TOP100_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(Top100Api::class.java)
    }

    companion object {
        const val API_TOP100_URL = "https://api.top100token.com/"
    }
}