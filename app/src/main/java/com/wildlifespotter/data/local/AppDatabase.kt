package com.wildlifespotter.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wildlifespotter.data.local.dao.SpeciesDao
import com.wildlifespotter.data.local.dao.SightingDao
import com.wildlifespotter.data.local.dao.UserDao
import com.wildlifespotter.data.local.entity.SpeciesEntity
import com.wildlifespotter.data.local.entity.SightingEntity
import com.wildlifespotter.data.local.entity.UserEntity
import android.content.Context

@Database(entities = [SpeciesEntity::class, SightingEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun speciesDao(): SpeciesDao
    abstract fun sightingDao(): SightingDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "wildlife_spotter_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}