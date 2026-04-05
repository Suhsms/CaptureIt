package com.wildlifespotter.ml

import android.graphics.Bitmap
import com.wildlifespotter.domain.model.Species
import kotlin.random.Random
import javax.inject.Inject

class SpeciesClassifier @Inject constructor() {

    fun classifySpecies(bitmap: Bitmap): Species {
        return getRandomSpecies()
    }

    private fun getRandomSpecies(): Species {
        val speciesList = listOf(
            Species(id = "1", commonName = "Eagle", scientificName = "Aquila chrysaetos", rarity = "RARE", imageUrl = "", description = "", isWild = true),
            Species(id = "2", commonName = "Deer", scientificName = "Cervidae", rarity = "UNCOMMON", imageUrl = "", description = "", isWild = true),
            Species(id = "3", commonName = "Butterfly", scientificName = "Lepidoptera", rarity = "RARE", imageUrl = "", description = "", isWild = true),
            Species(id = "4", commonName = "Sparrow", scientificName = "Passer domesticus", rarity = "COMMON", imageUrl = "", description = "", isWild = true),
            Species(id = "5", commonName = "Rabbit", scientificName = "Oryctolagus cuniculus", rarity = "UNCOMMON", imageUrl = "", description = "", isWild = true),
            Species(id = "6", commonName = "Fox", scientificName = "Vulpes vulpes", rarity = "RARE", imageUrl = "", description = "", isWild = true),
            Species(id = "7", commonName = "Squirrel", scientificName = "Sciurus vulgaris", rarity = "COMMON", imageUrl = "", description = "", isWild = true),
            Species(id = "8", commonName = "Dog", scientificName = "Canis familiaris", rarity = "COMMON", imageUrl = "", description = "", isWild = false),
            Species(id = "9", commonName = "Cat", scientificName = "Felis catus", rarity = "COMMON", imageUrl = "", description = "", isWild = false),
        )
        return speciesList[Random.nextInt(speciesList.size)]
    }
}