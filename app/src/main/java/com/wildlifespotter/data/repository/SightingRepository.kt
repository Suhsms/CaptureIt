package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.SightingDao
import com.wildlifespotter.data.local.entity.SightingEntity
import com.wildlifespotter.domain.model.Sighting
import javax.inject.Inject

class SightingRepository @Inject constructor(
    private val sightingDao: SightingDao
) {
    fun saveSighting(sighting: Sighting) {
        val sightingEntity = SightingEntity(
            id = sighting.id,
            speciesId = sighting.speciesId,
            userId = sighting.userId,
            location = sighting.location,
            photoUrl = sighting.photoUrl,
            timestamp = sighting.timestamp,
            rarityPoints = sighting.rarityPoints,
            photoQualityScore = sighting.qualityScore
        )
        sightingDao.insertSighting(sightingEntity)
    }

    fun getSightingsByUserId(userId: Long): List<Sighting> {
        return sightingDao.getSightingsByUserId(userId).map { entity ->
            Sighting(
                id = entity.id,
                speciesId = entity.speciesId,
                userId = entity.userId,
                location = entity.location,
                photoUrl = entity.photoUrl,
                timestamp = entity.timestamp,
                rarityPoints = entity.rarityPoints,
                qualityScore = entity.photoQualityScore
            )
        }
    }

    fun getAllSightings(): List<Sighting> {
        return emptyList() // Placeholder
    }
}