package com.ramiro.krogerbenchlc.data.repository

import com.ramiro.krogerbenchlc.data.domain.Cat
import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import retrofit2.Response

interface CatsRepository {

    suspend fun getCats(
        limit: Int,
        hasBreed: Int
    ): Response<List<CatsModelItemmodel>>
}