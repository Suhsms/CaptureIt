package com.wildlifespotter.domain.usecase

import com.wildlifespotter.domain.model.PointsResult
import com.wildlifespotter.domain.model.Sighting
import com.wildlifespotter.domain.model.Species
import javax.inject.Inject
import kotlin.math.roundToInt

class CalculatePointsUseCase @Inject constructor() {

    fun execute(sighting: Sighting): PointsResult {
        val rarityPoints = calculateRarityPoints(sighting.rarity)
        val qualityPoints = calculateQualityPoints(sighting.photoQuality)

        val totalPoints = rarityPoints + qualityPoints
        return PointsResult(totalPoints, sighting.rarity, rarityPoints, qualityPoints)
    }

    fun executeForSpecies(species: Species, photoQuality: Float = 0.5f): PointsResult {
        val rarityPoints = calculateRarityPoints(species.rarity)
        val qualityPoints = calculateQualityPoints(photoQuality)
        val totalPoints = rarityPoints + qualityPoints

        // Bonus for wild species
        val finalPoints = if (species.isWild) totalPoints + 2 else totalPoints
        return PointsResult(finalPoints, species.commonName, rarityPoints, qualityPoints)
    }

    private fun calculateRarityPoints(rarity: String): Int {
        return when (rarity.lowercase()) {
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