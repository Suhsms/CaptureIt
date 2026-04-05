package com.wildlifespotter.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wildlifespotter.data.local.entity.SightingEntity

@Dao
interface SightingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSighting(sighting: SightingEntity)

    @Query("SELECT * FROM sightings WHERE userId = :userId")
    fun getSightingsByUserId(userId: Long): List<SightingEntity>

    @Query("SELECT * FROM sightings WHERE id = :sightingId LIMIT 1")
    fun getSightingById(sightingId: Long): SightingEntity?

    @Query("DELETE FROM sightings WHERE id = :sightingId")
    fun deleteSightingById(sightingId: Long)
}