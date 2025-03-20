package com.ramiro.krogerbenchlc.domain

import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import com.ramiro.krogerbenchlc.data.repository.CatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(private val repository: CatsRepository) {

    operator fun invoke(limit: Int = 10, hasBreeds: Int =1):Flow<UiState<List<CatsModelItemmodel>>> = flow{
        emit(UiState.LOADING)
        try {
            val result = repository.getCats(limit, hasBreeds)
            if(result.isSuccessful && result.body() != null){
                emit(UiState.SUCCESS(result.body()!!))
            }else throw Exception(result.errorBody().toString())
        }catch (e: Exception){
            emit(UiState.ERROR(e))
        }
    }
}