package com.wildlifespotter.domain.usecase

import com.wildlifespotter.domain.model.PointsResult
import com.wildlifespotter.domain.model.Sighting
import kotlin.math.roundToInt

class CalculatePointsUseCase {

    fun execute(sighting: Sighting): PointsResult {
        val rarityPoints = calculateRarityPoints(sighting.rarity)
        val qualityPoints = calculateQualityPoints(sighting.photoQuality)

        val totalPoints = rarityPoints + qualityPoints
        return PointsResult(totalPoints)
    }

    private fun calculateRarityPoints(rarity: String): Int {
        return when (rarity) {
            "common" -> 1
            "uncommon" -> 3
            "rare" -> 5
            "very rare" -> 10
            else -> 0
        }
    }

    private fun calculateQualityPoints(photoQuality: Float): Int {
        return when {
            photoQuality >= 0.9 -> 5
            photoQuality >= 0.75 -> 3
            photoQuality >= 0.5 -> 1
            else -> 0
        }
    }
}