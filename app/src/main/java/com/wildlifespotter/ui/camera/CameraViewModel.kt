package com.wildlifespotter.ui.camera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase
import com.wildlifespotter.domain.usecase.CalculatePointsUseCase
import com.wildlifespotter.domain.usecase.SaveSightingUseCase
import kotlinx.coroutines.launch

class CameraViewModel(
    private val identifySpeciesUseCase: IdentifySpeciesUseCase,
    private val calculatePointsUseCase: CalculatePointsUseCase,
    private val saveSightingUseCase: SaveSightingUseCase
) : ViewModel() {

    fun capturePhoto(photo: ByteArray, location: String) {
        viewModelScope.launch {
            val species = identifySpeciesUseCase.execute(photo)
            val points = calculatePointsUseCase.execute(species)
            saveSightingUseCase.execute(species, location, points)
        }
    }
}