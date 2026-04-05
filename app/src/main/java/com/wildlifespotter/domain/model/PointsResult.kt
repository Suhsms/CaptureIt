package com.wildlifespotter.domain.model

data class PointsResult(
    val totalPoints: Int,
    val speciesName: String = "",
    val rarityScore: Int = 0,
    val photoQualityScore: Int = 0
)