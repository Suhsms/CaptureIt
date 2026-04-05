package com.wildlifespotter.domain.usecase

import android.graphics.Bitmap
import com.wildlifespotter.data.repository.SpeciesRepository
import com.wildlifespotter.ml.SpeciesClassifier
import com.wildlifespotter.domain.model.Species
import javax.inject.Inject

class IdentifySpeciesUseCase @Inject constructor(
    private val speciesRepository: SpeciesRepository,
    private val speciesClassifier: SpeciesClassifier
) {
    suspend fun execute(image: ByteArray): Result<Species> {
        return try {
            // For now, return a mock species
            val species = Species(
                commonName = "Unknown Animal",
                rarity = "uncommon"
            )
            Result.success(species)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun executeWithBitmap(bitmap: Bitmap): Result<Species> {
        return try {
            val identifiedSpecies = speciesClassifier.classifySpecies(bitmap)
            Result.success(identifiedSpecies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}