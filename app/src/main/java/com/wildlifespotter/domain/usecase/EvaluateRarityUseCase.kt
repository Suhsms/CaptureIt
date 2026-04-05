package com.wildlifespotter.domain.usecase

import com.wildlifespotter.data.repository.SpeciesRepository
import com.wildlifespotter.domain.model.PointsResult
import javax.inject.Inject

class EvaluateRarityUseCase @Inject constructor(
    private val speciesRepository: SpeciesRepository
) {
    fun evaluateRarity(speciesId: String, photoQuality: Int, speciesName: String): PointsResult {
        val rarityScore = speciesRepository.getRarityScore(speciesId)
        val points = calculatePoints(rarityScore, photoQuality)
        return PointsResult(points, speciesName, rarityScore, photoQuality)
    }

    private fun calculatePoints(rarityScore: Int, photoQuality: Int): Int {
        return (rarityScore * photoQuality) / 100
    }
}