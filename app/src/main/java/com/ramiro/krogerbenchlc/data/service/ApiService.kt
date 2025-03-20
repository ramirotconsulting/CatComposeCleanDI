package com.ramiro.krogerbenchlc.data.service

import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://api.thecatapi.com/v1/images/search?limit=10&has_breeds=1
    @GET("v1/images/search")
    suspend fun getCats(
        @Query("has_breeds") hasBreeds: Int,
        @Query("limit") limit:Int
    ): Response< List<CatsModelItemmodel>>
}