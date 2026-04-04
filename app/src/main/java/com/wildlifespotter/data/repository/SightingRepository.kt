package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.SightingDao
import com.wildlifespotter.data.local.entity.SightingEntity
import com.wildlifespotter.domain.model.Sighting
import com.wildlifespotter.domain.usecase.CalculatePointsUseCase
import com.wildlifespotter.domain.usecase.EvaluateRarityUseCase
import javax.inject.Inject

class SightingRepository @Inject constructor(
    private val sightingDao: SightingDao,
    private val calculatePointsUseCase: CalculatePointsUseCase,
    private val evaluateRarityUseCase: EvaluateRarityUseCase
) {
    suspend fun saveSighting(sighting: Sighting) {
        val sightingEntity = SightingEntity(
            id = sighting.id,
            speciesId = sighting.speciesId,
            userId = sighting.userId,
            location = sighting.location,
            photoUri = sighting.photoUri,
            timestamp = sighting.timestamp
        )
        sightingDao.insert(sightingEntity)
    }

    suspend fun getSightings(): List<Sighting> {
        return sightingDao.getAll().map { entity ->
            Sighting(
                id = entity.id,
                speciesId = entity.speciesId,
                userId = entity.userId,
                location = entity.location,
                photoUri = entity.photoUri,
                timestamp = entity.timestamp
            )
        }
    }

    suspend fun evaluateSighting(sighting: Sighting): Pair<Int, String> {
        val points = calculatePointsUseCase.execute(sighting)
        val rarity = evaluateRarityUseCase.execute(sighting.speciesId)
        return Pair(points, rarity)
    }
}