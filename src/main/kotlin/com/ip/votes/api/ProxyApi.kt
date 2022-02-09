package com.ip.votes.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import com.ip.votes.dto.Proxy
import com.ip.votes.dto.URLDto

interface ProxyApi {

    @POST("/proxy/api/save")
    fun save(@Body proxy: Proxy): Call<Void>

    @POST("/proxy/api/saveAll")
    fun saveAll(@Body proxy: List<Proxy>): Call<Void>

    @POST("/proxy/api/saveByUrl")
    fun saveByUrl(@Body urlDto: URLDto): Call<Void>

    @GET("/proxy/api/findNotUsedProxy")
    fun findNotUsedProxy(): Call<Proxy?>

    @GET("/proxy/api/findAllNotUsed")
    fun findAllNotUsed(): Call<List<Proxy?>?>

    @GET("/proxy/api/findAllNotUsedWithPort8080")
    fun findAllNotUsedWithPort8080(): Call<List<Proxy?>?>

    @POST("/proxy/api/updateUsedProxy")
    fun updateUsedProxy(@Body urlDto: URLDto): Call<Void>

}