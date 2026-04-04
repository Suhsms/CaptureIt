package com.wildlifespotter.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wildlifespotter.data.local.entity.SpeciesEntity

@Dao
interface SpeciesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpecies(species: SpeciesEntity)

    @Query("SELECT * FROM species WHERE id = :id")
    suspend fun getSpeciesById(id: String): SpeciesEntity?

    @Query("SELECT * FROM species")
    suspend fun getAllSpecies(): List<SpeciesEntity>

    @Query("DELETE FROM species")
    suspend fun deleteAllSpecies()
}