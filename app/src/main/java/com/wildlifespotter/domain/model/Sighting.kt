package com.wildlifespotter.domain.model

data class Sighting(
    val id: Long = 0,
    val speciesId: Long,
    val userId: Long,
    val location: String,
    val timestamp: Long = System.currentTimeMillis(),
    val photoUrl: String = "",
    val rarityPoints: Int = 0,
    val qualityScore: Int = 0,
    val rarity: String = "common",
    val photoQuality: Float = 0.5f
) {
    fun calculateTotalPoints(): Int {
        return rarityPoints + qualityScore
    }
}