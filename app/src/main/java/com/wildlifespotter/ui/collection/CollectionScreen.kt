package com.wildlifespotter.ui.collection

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wildlifespotter.ui.collection.CollectionViewModel

@Composable
fun CollectionScreen(
    viewModel: CollectionViewModel = viewModel()
) {
    val collectedSpecies = viewModel.collectedSpecies

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My Collection") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (collectedSpecies.isEmpty()) {
                Text("No species collected yet.")
            } else {
                LazyColumn {
                    items(collectedSpecies) { species ->
                        SpeciesItem(species)
                    }
                }
            }
        }
    }
}

@Composable
fun SpeciesItem(species: Species) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = species.name, style = MaterialTheme.typography.h6)
            Text(text = "Rarity: ${species.rarity}")
            Text(text = "Points: ${species.points}")
        }
    }
}