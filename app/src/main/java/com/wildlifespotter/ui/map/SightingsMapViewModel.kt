package com.wildlifespotter.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildlifespotter.domain.model.Sighting
import com.wildlifespotter.domain.usecase.EvaluateRarityUseCase
import com.wildlifespotter.domain.usecase.SaveSightingUseCase
import com.wildlifespotter.location.LocationProvider

class SightingsMapViewModel(
    private val saveSightingUseCase: SaveSightingUseCase,
    private val evaluateRarityUseCase: EvaluateRarityUseCase,
    private val locationProvider: LocationProvider
) : ViewModel() {

    private val _sightings = MutableLiveData<List<Sighting>>()
    val sightings: LiveData<List<Sighting>> get() = _sightings

    fun addSighting(sighting: Sighting) {
        saveSightingUseCase.execute(sighting)
        updateSightings()
    }

    private fun updateSightings() {
        // Logic to update sightings from the database or API
    }

    fun evaluateSightingRarity(sighting: Sighting): Int {
        return evaluateRarityUseCase.execute(sighting)
    }

    fun getCurrentLocation() = locationProvider.getCurrentLocation()
}