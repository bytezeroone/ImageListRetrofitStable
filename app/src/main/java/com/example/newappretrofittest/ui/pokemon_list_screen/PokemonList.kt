package com.example.newappretrofittest.ui.pokemon_list_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newappretrofittest.data.models.ListEntry

@Composable
fun PokemonList(
    viewModel: PokemonListViewModel = hiltViewModel(),
    entries: List<ListEntry>
) {
    val pokemonList by remember { viewModel.pokemonList }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = pokemonList.size

        items(itemCount) {
            if (it >= itemCount - 1 && !isLoading) {
                viewModel.loadImagePaginated()
            }
            Spacer(modifier = Modifier.height(8.dp))
            PokedexEntry(entry = entries[it])
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                viewModel.loadImagePaginated()
            }
        }
    }
}