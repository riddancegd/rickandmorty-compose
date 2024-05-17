package com.example.rickandmorty_compose.data.repository

import com.example.rickandmorty_compose.data.api.RickAndMortyApi
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.data.model.CharacterResponse
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api: RickAndMortyApi) {

    suspend fun getCharacters(page: Int): List<Character>? {
        // Ensure you call the correct functions on the Response object
        val response: Response<CharacterResponse> = api.getCharacters(page)
        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            null // Consider logging or handling the error case here
        }
    }
}