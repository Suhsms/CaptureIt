package com.wildlifespotter.ml

import android.graphics.Bitmap
import org.tensorflow.lite.Interpreter

class SpeciesClassifier(private val model: Interpreter) {

    fun classifySpecies(image: Bitmap): String {
        // Preprocess the image and run the model
        val input = preprocessImage(image)
        val output = Array(1) { Array(1) { FloatArray(NUM_CLASSES) } }
        model.run(input, output)
        return getPredictedSpecies(output)
    }

    private fun preprocessImage(image: Bitmap): Array<Array<FloatArray>> {
        // Resize and normalize the image for the model
        val resizedImage = Bitmap.createScaledBitmap(image, IMAGE_SIZE, IMAGE_SIZE, true)
        val input = Array(1) { Array(IMAGE_SIZE) { FloatArray(IMAGE_SIZE * 3) } }
        for (x in 0 until IMAGE_SIZE) {
            for (y in 0 until IMAGE_SIZE) {
                val pixel = resizedImage.getPixel(x, y)
                input[0][x][y * 3] = ((pixel shr 16 and 0xFF) / 255.0f) // Red
                input[0][x][y * 3 + 1] = ((pixel shr 8 and 0xFF) / 255.0f) // Green
                input[0][x][y * 3 + 2] = ((pixel and 0xFF) / 255.0f) // Blue
            }
        }
        return input
    }

    private fun getPredictedSpecies(output: Array<Array<FloatArray>>): String {
        // Logic to interpret the model output and return the predicted species
        val predictedIndex = output[0][0].indices.maxByOrNull { output[0][0][it] } ?: -1
        return SPECIES_LIST[predictedIndex]
    }

    companion object {
        private const val IMAGE_SIZE = 224
        private const val NUM_CLASSES = 10 // Adjust based on your model
        private val SPECIES_LIST = arrayOf("Species A", "Species B", "Species C") // Add actual species names
    }
}