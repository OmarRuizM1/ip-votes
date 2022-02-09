package com.ip.votes.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.ip.votes.dto.AppAndUrlRequest
import com.ip.votes.dto.AppDto
import com.ip.votes.dto.ProxyApp

interface ProxyAppApi {

    @POST("/proxyApp/api/saveByUrl")
    fun saveByUrl(@Body appAndUrlRequest: AppAndUrlRequest): Call<Void>

    @POST("/proxyApp/api/save")
    fun save(@Body proxyApp: ProxyApp): Call<Void>

    @POST("/proxyApp/api/saveAll")
    fun saveAll(@Body proxyApp: List<ProxyApp>): Call<Void>

    @POST("/proxyApp/api/findAllNotUsed")
    fun findAllNotUsed(@Body appDto: AppDto): Call<List<ProxyApp?>?>

    @POST("/proxyApp/api/findAllNotUsedWithPort8080")
    fun findAllNotUsedWithPort8080(@Body appDto: AppDto): Call<List<ProxyApp?>?>

    @POST("/proxyApp/api/updateUsedProxy")
    fun updateUsedProxy(@Body appAndUrlRequest: AppAndUrlRequest): Call<Void>

}