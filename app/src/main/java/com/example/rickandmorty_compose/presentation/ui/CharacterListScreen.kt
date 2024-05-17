package com.example.rickandmorty_compose.presentation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty_compose.R
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.presentation.preview.PreviewUtils.sampleCharacterData
import com.example.rickandmorty_compose.presentation.viewmodel.CharacterViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel = hiltViewModel()) {
    val characters = viewModel.characters.collectAsState().value

    LazyColumn (

        //verticalArrangement = Arrangement.spacedBy((-30).dp),
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 20.dp),

        ) {
        item {
            Header()
        }
        items(items = characters ?: emptyList(), itemContent = { character ->
            CharacterListItem(character)
        })
    }
}

@Composable
fun CharacterListItem(character: Character) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 3.dp,
        modifier = Modifier.paddingFromBaseline(
            bottom = 40.dp
        )
    ) {
        Row(
            modifier = Modifier
                //.width(IntrinsicSize.Max)
                .fillMaxWidth()
        )

            {
            GlideImage(
                previewPlaceholder = painterResource(R.drawable.image_avatar),
                imageModel = { character.image },
                modifier = Modifier
                    .size(80.dp)
                    //.clip(CircleShape)
                    //.border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text(
                    modifier = Modifier.paddingFromBaseline(
                        top = 20.dp
                    ),
                    text = character.name,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(2.dp))

                Button(onClick = { /* Handle show detail action */ }) {
                    Text("Show Detail")
                }

            }

        }
    }

/*    Column {
        GlideImage(
            imageModel = character.image,
            previewPlaceholder = painterResource(id = R.drawable.image_avatar)
        )
        Text(text = character.name)
        Button(onClick = { *//* Handle show detail action *//* }) {
            Text("Show Detail")
        }
    }*/
}

// Preview Composable
@Preview(showBackground = true)
@Composable
fun CharacterListScreenPreview() {
    // Using sample data for the preview
    CharacterListScreen(characters = sampleCharacterData())
}

// Assume this Composable is your actual screen Composable
@Composable
fun CharacterListScreen(characters: List<Character>) {
    LazyColumn (

        //verticalArrangement = Arrangement.spacedBy((-30).dp),
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 20.dp),

    ) {
        item {
            Header()
        }

        items(characters) { character ->
            CharacterListItem(character)
        }
    }
}