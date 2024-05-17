package com.example.rickandmorty_compose.data.api

import com.example.rickandmorty_compose.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): Response<CharacterResponse>
}