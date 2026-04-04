package com.wildlifespotter.ui.collection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wildlifespotter.domain.model.Sighting
import com.wildlifespotter.domain.usecase.EvaluateRarityUseCase
import com.wildlifespotter.domain.usecase.SaveSightingUseCase

class CollectionViewModel(
    private val saveSightingUseCase: SaveSightingUseCase,
    private val evaluateRarityUseCase: EvaluateRarityUseCase
) : ViewModel() {

    private val _sightings = MutableLiveData<List<Sighting>>()
    val sightings: LiveData<List<Sighting>> get() = _sightings

    fun addSighting(sighting: Sighting) {
        saveSightingUseCase.execute(sighting)
        updateSightings()
    }

    private fun updateSightings() {
        // Logic to fetch and update the list of sightings
    }

    fun evaluateRarity(sighting: Sighting): Int {
        return evaluateRarityUseCase.execute(sighting)
    }
}