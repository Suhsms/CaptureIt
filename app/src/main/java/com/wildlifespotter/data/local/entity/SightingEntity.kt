package com.wildlifespotter.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sightings")
data class SightingEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val speciesId: Long,
    val userId: Long,
    val location: String,
    val photoUrl: String,
    val timestamp: Long,
    val rarityPoints: Int,
    val photoQualityScore: Int
)