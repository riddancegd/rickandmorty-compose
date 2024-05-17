package com.example.rickandmorty_compose.presentation.preview

import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.data.model.Location
import com.example.rickandmorty_compose.data.model.Origin

object PreviewUtils {

    fun sampleCharacterData() = listOf(
        Character(
            name = "Rick Sanchez",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(name = "Earth (C-137)"),
            location = Location(name = "Earth (Replacement Dimension)")
        ),
        Character(
            name = "Morty Smith",
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(name = "Earth (C-137)"),
            location = Location(name = "Earth (Replacement Dimension)")
        )
    )

}