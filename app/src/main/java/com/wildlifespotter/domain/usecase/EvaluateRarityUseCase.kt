package com.wildlifespotter.domain.usecase

import com.wildlifespotter.data.repository.SpeciesRepository
import com.wildlifespotter.domain.model.PointsResult
import javax.inject.Inject

class EvaluateRarityUseCase @Inject constructor(
    private val speciesRepository: SpeciesRepository
) {
    suspend fun evaluateRarity(speciesId: String, photoQuality: Int, userLocation: String): PointsResult {
        val rarityScore = speciesRepository.getRarityScore(speciesId)
        val points = calculatePoints(rarityScore, photoQuality)
        return PointsResult(speciesId, points, rarityScore)
    }

    private fun calculatePoints(rarityScore: Int, photoQuality: Int): Int {
        return (rarityScore * photoQuality) / 100
    }
}