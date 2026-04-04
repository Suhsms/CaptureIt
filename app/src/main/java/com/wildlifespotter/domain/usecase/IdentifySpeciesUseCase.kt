package com.wildlifespotter.domain.usecase

import com.wildlifespotter.data.repository.SpeciesRepository
import com.wildlifespotter.ml.SpeciesClassifier
import com.wildlifespotter.domain.model.Species

class IdentifySpeciesUseCase(
    private val speciesRepository: SpeciesRepository,
    private val speciesClassifier: SpeciesClassifier
) {
    suspend fun execute(image: ByteArray): Result<Species> {
        return try {
            val identifiedSpecies = speciesClassifier.classify(image)
            val speciesDetails = speciesRepository.getSpeciesByName(identifiedSpecies.name)
            Result.success(speciesDetails)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}