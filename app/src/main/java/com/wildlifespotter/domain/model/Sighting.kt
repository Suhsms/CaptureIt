package com.wildlifespotter.domain.model

data class Sighting(
    val id: Long,
    val speciesId: Long,
    val userId: Long,
    val location: String,
    val timestamp: Long,
    val photoUrl: String,
    val rarityPoints: Int,
    val qualityScore: Int
) {
    fun calculateTotalPoints(): Int {
        return rarityPoints + qualityScore
    }
}