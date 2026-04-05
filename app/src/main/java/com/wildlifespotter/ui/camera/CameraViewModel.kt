package com.wildlifespotter.ui.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase
import com.wildlifespotter.domain.usecase.CalculatePointsUseCase
import com.wildlifespotter.domain.usecase.SaveSightingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val identifySpeciesUseCase: IdentifySpeciesUseCase,
    private val calculatePointsUseCase: CalculatePointsUseCase,
    private val saveSightingUseCase: SaveSightingUseCase
) : ViewModel() {

    private val _identifiedSpecies = MutableStateFlow<String?>(null)
    val identifiedSpecies: StateFlow<String?> = _identifiedSpecies

    private val _points = MutableStateFlow<Int>(0)
    val points: StateFlow<Int> = _points

    fun onSpeciesIdentified(speciesName: String) {
        viewModelScope.launch {
            _identifiedSpecies.value = speciesName
            // Calculate points based on species
            _points.value = 10 // Default points
        }
    }

    fun capturePhoto(photo: ByteArray, location: String) {
        viewModelScope.launch {
            try {
                val result = identifySpeciesUseCase.execute(photo)
                result.onSuccess { species ->
                    _identifiedSpecies.value = species.commonName
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}