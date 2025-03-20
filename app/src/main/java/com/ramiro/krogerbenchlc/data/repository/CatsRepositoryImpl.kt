package com.ramiro.krogerbenchlc.data.repository

import com.ramiro.krogerbenchlc.data.domain.Cat
import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import com.ramiro.krogerbenchlc.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(private val service: ApiService): CatsRepository {
    override suspend fun getCats(limit: Int, hasBreed: Int): Response<List<CatsModelItemmodel>> {
        return service.getCats(hasBreed, limit)
    }
}