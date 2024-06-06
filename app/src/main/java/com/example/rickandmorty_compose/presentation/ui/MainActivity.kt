package com.example.rickandmorty_compose.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty_compose.presentation.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.characters.collectAsState()
            val isRefreshing by viewModel.isRefreshing.collectAsState()

            CharacterListScreen(
                uiState = uiState,
                isRefreshing = isRefreshing,
                onRefresh = { viewModel.refreshCharacters(1) }
            )
        }
    }
}