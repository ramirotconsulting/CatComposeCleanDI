package com.ramiro.krogerbenchlc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramiro.krogerbenchlc.ui.CatScreen
import com.ramiro.krogerbenchlc.ui.theme.KrogerBenchLCTheme
import com.ramiro.krogerbenchlc.ui.viewmodel.CatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KrogerBenchLCTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeContent) { innerPadding ->
                    val viewModel = hiltViewModel<CatsViewModel>()
                    CatScreen(viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
