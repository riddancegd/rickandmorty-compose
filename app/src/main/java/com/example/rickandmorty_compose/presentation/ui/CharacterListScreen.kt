package com.example.rickandmorty_compose.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty_compose.R
import com.example.rickandmorty_compose.data.model.Character
import com.example.rickandmorty_compose.presentation.preview.PreviewUtils.sampleCharacterData
import com.example.rickandmorty_compose.presentation.viewmodel.CharacterViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListScreen(
    characters: List<Character>? = null,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val characterList by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val displayedCharacters = characters ?: characterList

    LazyColumn(
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 20.dp),
    ) {
        item { Header() }
        if (isLoading && displayedCharacters == null) {
            items(5) { // Show 5 shimmer items for loading effect
                ShimmerCharacterListItem()
            }
        } else {
            items(items = displayedCharacters ?: emptyList()) { character ->
                CharacterListItem(character)
            }
        }
    }
}

@Composable
fun CharacterListItem(character: Character) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 3.dp,
        modifier = Modifier
            .padding(vertical = 6.dp)

    ) {
        Column(modifier = Modifier.fillMaxWidth()

            .animateContentSize(animationSpec = tween(durationMillis = 100))

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                GlideImage(
                    previewPlaceholder = painterResource(R.drawable.image_avatar),
                    imageModel = { character.image },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp))

                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = character.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Button(
                        onClick = { expanded = !expanded },
                        elevation = ButtonDefaults.elevatedButtonElevation(3.dp)
                        ) {
                        Text(if (expanded) "Hide Detail" else "Show Detail")
                    }
                }
            }
            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailText(label = "Status", value = character.status)
                    DetailText(label = "Species", value = character.species)
                    DetailText(label = "Type", value = character.type)
                    DetailText(label = "Gender", value = character.gender)
                    DetailText(label = "Origin", value = character.origin.name)
                    DetailText(label = "Location", value = character.location.name)
                }
            }
        }
    }
}

@Composable
fun DetailText(label: String, value: String) {
    Row {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("•   $label: ")
                }
                append(value)
            }
        )
    }
}


// Preview Composable
@Preview(showBackground = true)
@Composable
fun CharacterListScreenPreview() {
    // Using sample data for the preview
    CharacterListScreen(characters = sampleCharacterData())
}
