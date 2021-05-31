package com.hyunday.greenery_android

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

public interface GreeneryApi {
    @GET("/data")
    suspend fun getRequest(): Response<List<Pojo>>
}