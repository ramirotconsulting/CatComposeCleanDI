package com.ramiro.krogerbenchlc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import com.ramiro.krogerbenchlc.domain.GetCatsUseCase
import com.ramiro.krogerbenchlc.domain.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val getCatsUseCase: GetCatsUseCase,
    private val dispatcher: CoroutineDispatcher): ViewModel() {

        private val _catsState: MutableStateFlow<UiState<List<CatsModelItemmodel>>> = MutableStateFlow(UiState.LOADING)
    val catsState: StateFlow<UiState<List<CatsModelItemmodel>>> = _catsState.asStateFlow()

    init {
        getCats()
    }

    private fun getCats(){
        viewModelScope.launch(dispatcher) {
            getCatsUseCase.invoke().collect{
                _catsState.value = it
            }
        }
    }
}