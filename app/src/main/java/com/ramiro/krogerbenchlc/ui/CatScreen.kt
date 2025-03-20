package com.ramiro.krogerbenchlc.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.ramiro.krogerbenchlc.data.model.Breedmodel
import com.ramiro.krogerbenchlc.data.model.CatsModelItemmodel
import com.ramiro.krogerbenchlc.domain.UiState
import com.ramiro.krogerbenchlc.ui.viewmodel.CatsViewModel

@Composable
fun CatScreen(viewModel: CatsViewModel, modifier: Modifier){
    val state = viewModel.catsState.collectAsStateWithLifecycle().value

    when(state){
        is UiState.ERROR -> Log.d("CatScreen", "${state.error.localizedMessage}")
        UiState.LOADING -> {
            Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                CircularProgressIndicator()
            }
        }
        is UiState.SUCCESS -> {
            val listResults: List<CatsModelItemmodel> = state.response
            LazyColumn {
                items(listResults){ cat ->
                    Card {
                        AsyncImage(model = cat.url, contentDescription = "Cat image")
                        Text(text = cat.id!!)
                        Text(text = "${cat.breeds}")
                    }
                }
            }
        }
    }

}