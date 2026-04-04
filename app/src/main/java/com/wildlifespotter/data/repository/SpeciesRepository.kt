package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.SpeciesDao
import com.wildlifespotter.data.remote.api.SpeciesIdentificationApi
import com.wildlifespotter.domain.model.Species
import com.wildlifespotter.domain.model.PointsResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SpeciesRepository @Inject constructor(
    private val speciesDao: SpeciesDao,
    private val speciesIdentificationApi: SpeciesIdentificationApi
) {
    suspend fun getSpeciesById(id: String): Species? {
        return withContext(Dispatchers.IO) {
            speciesDao.getSpeciesById(id)
        }
    }

    suspend fun identifySpecies(image: ByteArray): Species? {
        return withContext(Dispatchers.IO) {
            val response = speciesIdentificationApi.identifySpecies(image)
            response?.let {
                Species(it.name, it.rarity, it.imageUrl)
            }
        }
    }

    suspend fun calculatePoints(species: Species, photoQuality: Int): PointsResult {
        return withContext(Dispatchers.IO) {
            val rarityPoints = when (species.rarity) {
                "Common" -> 1
                "Uncommon" -> 3
                "Rare" -> 5
                "Very Rare" -> 10
                else -> 0
            }
            val qualityPoints = when {
                photoQuality > 80 -> 5
                photoQuality > 50 -> 3
                else -> 1
            }
            PointsResult(rarityPoints + qualityPoints)
        }
    }
}