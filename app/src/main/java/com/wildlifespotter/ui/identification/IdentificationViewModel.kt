package com.wildlifespotter.ui.identification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wildlifespotter.domain.model.PointsResult
import com.wildlifespotter.domain.usecase.CalculatePointsUseCase
import com.wildlifespotter.domain.usecase.EvaluateRarityUseCase
import com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase
import kotlinx.coroutines.launch

class IdentificationViewModel(
    private val identifySpeciesUseCase: IdentifySpeciesUseCase,
    private val calculatePointsUseCase: CalculatePointsUseCase,
    private val evaluateRarityUseCase: EvaluateRarityUseCase
) : ViewModel() {

    private val _identifiedSpecies = MutableLiveData<String>()
    val identifiedSpecies: LiveData<String> get() = _identifiedSpecies

    private val _pointsResult = MutableLiveData<PointsResult>()
    val pointsResult: LiveData<PointsResult> get() = _pointsResult

    fun identifySpecies(imageUri: String) {
        viewModelScope.launch {
            val species = identifySpeciesUseCase.execute(imageUri)
            _identifiedSpecies.value = species
            calculatePoints(species)
        }
    }

    private fun calculatePoints(species: String) {
        viewModelScope.launch {
            val points = calculatePointsUseCase.execute(species)
            _pointsResult.value = points
            evaluateRarity(species)
        }
    }

    private fun evaluateRarity(species: String) {
        viewModelScope.launch {
            evaluateRarityUseCase.execute(species)
        }
    }
}