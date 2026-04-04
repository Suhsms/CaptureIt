import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatePointsUseCaseTest {

    private val calculatePointsUseCase = CalculatePointsUseCase()

    @Test
    fun `test points calculation for common species`() {
        val speciesRarity = "common"
        val photoQuality = 80 // out of 100
        val expectedPoints = 10 // example points for common species

        val result = calculatePointsUseCase.calculatePoints(speciesRarity, photoQuality)

        assertEquals(expectedPoints, result)
    }

    @Test
    fun `test points calculation for rare species`() {
        val speciesRarity = "rare"
        val photoQuality = 90 // out of 100
        val expectedPoints = 50 // example points for rare species

        val result = calculatePointsUseCase.calculatePoints(speciesRarity, photoQuality)

        assertEquals(expectedPoints, result)
    }

    @Test
    fun `test points calculation for very rare species with low photo quality`() {
        val speciesRarity = "very rare"
        val photoQuality = 40 // out of 100
        val expectedPoints = 20 // example points for very rare species with low quality

        val result = calculatePointsUseCase.calculatePoints(speciesRarity, photoQuality)

        assertEquals(expectedPoints, result)
    }

    @Test
    fun `test points calculation for very rare species with high photo quality`() {
        val speciesRarity = "very rare"
        val photoQuality = 95 // out of 100
        val expectedPoints = 100 // example points for very rare species with high quality

        val result = calculatePointsUseCase.calculatePoints(speciesRarity, photoQuality)

        assertEquals(expectedPoints, result)
    }
}