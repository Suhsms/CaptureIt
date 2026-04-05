package com.wildlifespotter.di

import android.content.Context
import androidx.room.Room
import com.wildlifespotter.data.local.AppDatabase
import com.wildlifespotter.data.local.dao.SpeciesDao
import com.wildlifespotter.data.local.dao.SightingDao
import com.wildlifespotter.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wildlife_spotter_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSpeciesDao(database: AppDatabase): SpeciesDao = database.speciesDao()

    @Provides
    @Singleton
    fun provideSightingDao(database: AppDatabase): SightingDao = database.sightingDao()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()
}