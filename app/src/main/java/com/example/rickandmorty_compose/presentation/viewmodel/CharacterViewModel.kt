package com.example.rickandmorty_compose.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty_compose.data.repository.CharacterRepository
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.presentation.ui.UiState
import com.example.rickandmorty_compose.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _characters = MutableStateFlow<UiState<List<Character>>>(UiState.Loading)
    val characters: StateFlow<UiState<List<Character>>> = _characters

    // State to track refresh status
    var isRefreshing = MutableStateFlow(false)

    init {
        fetchCharacters(1)
    }

    fun fetchCharacters(page: Int) {
        viewModelScope.launch {
            if (!NetworkUtils.isInternetAvailable(getApplication<Application>())) {
                _characters.value = UiState.Error("No internet connection")
                return@launch
            }

            try {
                val result = repository.getCharacters(page)
                result.fold(
                    onSuccess = { characters ->
                        _characters.value = UiState.Success(characters)
                    },
                    onFailure = { exception ->
                        _characters.value = UiState.Error("Error: ${exception.message}")
                    }
                )
            } catch (e: Exception) {
                _characters.value = UiState.Error("Error: ${e.message}")
            }
        }
    }

    fun refreshCharacters(page: Int) {
        viewModelScope.launch {
            isRefreshing.value = true
            if (!NetworkUtils.isInternetAvailable(getApplication<Application>())) {
                _characters.value = UiState.Error("No internet connection")
                isRefreshing.value = false
                return@launch
            }

            try {
                val result = repository.getCharacters(page)
                result.fold(
                    onSuccess = { characters ->
                        _characters.value = UiState.Success(characters)
                    },
                    onFailure = { exception ->
                        _characters.value = UiState.Error("Error: ${exception.message}")
                    }
                )
            } catch (e: Exception) {
                _characters.value = UiState.Error("Error: ${e.message}")
            } finally {
                isRefreshing.value = false
            }
        }
    }
}