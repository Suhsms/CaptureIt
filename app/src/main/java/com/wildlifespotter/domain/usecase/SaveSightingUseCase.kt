package com.wildlifespotter.domain.usecase

import com.wildlifespotter.data.repository.SightingRepository
import com.wildlifespotter.domain.model.Sighting
import javax.inject.Inject

class SaveSightingUseCase @Inject constructor(
    private val sightingRepository: SightingRepository
) {
    suspend operator fun invoke(sighting: Sighting) {
        sightingRepository.saveSighting(sighting)
    }
}