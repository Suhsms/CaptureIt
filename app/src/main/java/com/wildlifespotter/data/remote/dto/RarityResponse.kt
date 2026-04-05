package com.wildlifespotter.data.remote.dto

data class RarityResponse(
    val speciesName: String,
    val rarityScore: Int,
    val rarityDescription: String,
    val location: String
)