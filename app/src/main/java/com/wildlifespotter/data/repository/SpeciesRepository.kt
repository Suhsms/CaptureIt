package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.SpeciesDao
import com.wildlifespotter.data.local.entity.SpeciesEntity
import com.wildlifespotter.domain.model.Species
import javax.inject.Inject

class SpeciesRepository @Inject constructor(
    private val speciesDao: SpeciesDao
) {
    fun getSpeciesById(id: Long): Species? {
        return speciesDao.getSpeciesById(id.toString())?.toSpecies()
    }

    fun getSpeciesByName(name: String): Species? {
        return speciesDao.getAllSpecies().find { 
            it.name.equals(name, ignoreCase = true) 
        }?.toSpecies()
    }

    fun getAllSpecies(): List<Species> {
        return speciesDao.getAllSpecies().map { it.toSpecies() }
    }

    fun saveSpecies(species: SpeciesEntity) {
        speciesDao.insertSpecies(species)
    }

    fun getRarityScore(speciesId: String): Int {
        // Return rarity score from 1-10 based on species
        return when (getSpeciesById(speciesId.toLongOrNull() ?: 0L)?.rarity) {
            "VERY_RARE" -> 10
            "RARE" -> 8
            "UNCOMMON" -> 5
            "COMMON" -> 2
            else -> 5
        }
    }

    private fun SpeciesEntity.toSpecies(): Species {
        return Species(
            id = id.toString(),
            commonName = name,
            scientificName = scientificName,
            rarity = rarity
        )
    }
}