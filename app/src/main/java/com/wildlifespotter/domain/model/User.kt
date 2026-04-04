package com.wildlifespotter.domain.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val points: Int,
    val sightingsCount: Int
)