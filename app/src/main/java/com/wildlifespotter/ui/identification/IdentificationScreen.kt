package com.wildlifespotter.ui.identification

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wildlifespotter.domain.model.Species
import com.wildlifespotter.ui.theme.WildlifeSpotterTheme

@Composable
fun IdentificationScreen(
    viewModel: IdentificationViewModel = viewModel()
) {
    val species by viewModel.species.collectAsState(initial = null)
    val isLoading by viewModel.isLoading.collectAsState(initial = false)

    WildlifeSpotterTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                } else {
                    species?.let {
                        Text(text = "Identified Species: ${it.name}")
                        Text(text = "Rarity: ${it.rarity}")
                        Text(text = "Points: ${it.points}")
                    } ?: run {
                        Text(text = "No species identified yet.")
                    }
                }
            }
        }
    }
}