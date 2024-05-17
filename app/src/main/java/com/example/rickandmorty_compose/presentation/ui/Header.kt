package com.example.rickandmorty_compose.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmorty_compose.R
import com.example.rickandmorty_compose.presentation.preview.PreviewUtils

@Composable
fun Header() {
    Column (

        modifier = Modifier.paddingFromBaseline(
            bottom = 30.dp
        )

    ) {
        Image(
            painter = painterResource(id = R.drawable.header_logo),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = androidx.compose.ui.Modifier
                .height(120.dp)
                //.padding(end = 32.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Welcome!",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(text = "This is a list of characters (Fr)",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    // Using sample data for the preview
    Header()
}