package com.wildlifespotter.di

import android.content.Context
import androidx.room.Room
import com.wildlifespotter.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "wildlife_spotter_db"
        ).build()
    }

    @Provides
    fun provideSpeciesDao(database: AppDatabase) = database.speciesDao()

    @Provides
    fun provideSightingDao(database: AppDatabase) = database.sightingDao()

    @Provides
    fun provideUserDao(database: AppDatabase) = database.userDao()
}