package com.example.rickandmorty_compose.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results") val results: List<Character>
)

data class Character(
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
    @SerializedName("origin") val origin: Origin,
    @SerializedName("location") val location: Location
)

data class Origin(
    @SerializedName("name") val name: String
)

data class Location(
    @SerializedName("name") val name: String
)