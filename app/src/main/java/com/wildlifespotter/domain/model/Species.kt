package com.wildlifespotter.domain.model

data class Species(
    val id: String = "",
    val commonName: String,
    val scientificName: String = "",
    val rarity: String = "common",
    val imageUrl: String = "",
    val description: String = "",
    val isWild: Boolean = true
)