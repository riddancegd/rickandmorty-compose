package com.example.rickandmorty_compose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.data.repository.CharacterRepository
import com.example.rickandmorty_compose.presentation.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) : ViewModel() {
    private val _characters = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    val characters: StateFlow<UiState<List<Character>>> = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            _characters.value = UiState.Loading
            try {
                val response = repository.getCharacters(1)
                if (response != null) {
                    if (response.isNotEmpty()) {
                        _characters.value = UiState.Success(response)
                    } else {
                        _characters.value = UiState.Error("No characters found")
                    }
                }
            } catch (e: Exception) {
                _characters.value = UiState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}