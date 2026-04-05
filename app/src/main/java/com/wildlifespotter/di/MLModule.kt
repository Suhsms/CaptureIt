package com.wildlifespotter.di

import com.wildlifespotter.ml.SpeciesClassifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MLModule {

    @Provides
    @Singleton
    fun provideSpeciesClassifier(): SpeciesClassifier {
        return SpeciesClassifier()
    }
}
