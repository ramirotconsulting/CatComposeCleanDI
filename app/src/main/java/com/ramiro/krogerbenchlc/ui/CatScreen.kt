package com.ramiro.krogerbenchlc.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
            LazyColumn(modifier.fillMaxSize()) {
                items(listResults){ cat ->
                    Card(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                        AsyncImage(model = cat.url, contentDescription = "Cat image", contentScale = ContentScale.FillWidth)
                        Text(text = "Cat ID: ${cat.id!!}")
                        Text(text = "Breed ID: ${cat.breeds?.get(0)?.id}")
                        Text(text = "Name: ${cat.breeds?.joinToString{
                            it.name ?: ""
                            }}")
                        Text(text = "Description: ${cat.breeds?.joinToString{
                            it.description ?: ""
                        }}")
                        Text(text = "Lifespan: ${cat.breeds?.joinToString{
                            it.lifeSpan ?: ""
                        }}")

                    }
                }
            }
        }
    }

}