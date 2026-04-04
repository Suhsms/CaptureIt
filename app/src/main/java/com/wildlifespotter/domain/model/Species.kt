package com.wildlifespotter.domain.model

data class Species(
    val id: String,
    val commonName: String,
    val scientificName: String,
    val rarity: String,
    val imageUrl: String,
    val description: String
)