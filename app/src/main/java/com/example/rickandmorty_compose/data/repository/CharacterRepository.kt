package com.example.rickandmorty_compose.data.repository

import com.example.rickandmorty_compose.data.api.RickAndMortyApi
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.data.model.CharacterResponse
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api: RickAndMortyApi) {

    suspend fun getCharacters(page: Int): Result<List<Character>> {
        return try {
            val response: Response<CharacterResponse> = api.getCharacters(page)
            if (response.isSuccessful) {
                val characters = response.body()?.results
                if (characters != null) {
                    Result.success(characters)
                } else {
                    Result.failure(Exception("No characters found"))
                }
            } else {
                Result.failure(Exception("Error ${response.code()}: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}