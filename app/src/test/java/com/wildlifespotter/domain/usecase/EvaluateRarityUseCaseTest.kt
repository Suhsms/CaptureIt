import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EvaluateRarityUseCaseTest {

    private lateinit var evaluateRarityUseCase: EvaluateRarityUseCase

    @Before
    fun setUp() {
        evaluateRarityUseCase = EvaluateRarityUseCase()
    }

    @Test
    fun testEvaluateRarity_withCommonSpecies_returnsLowRarity() {
        val species = Species("Common Sparrow", "common", 0.1)
        val result = evaluateRarityUseCase.evaluate(species)
        assertEquals("Expected rarity to be low", Rarity.LOW, result)
    }

    @Test
    fun testEvaluateRarity_withRareSpecies_returnsHighRarity() {
        val species = Species("California Condor", "rare", 0.01)
        val result = evaluateRarityUseCase.evaluate(species)
        assertEquals("Expected rarity to be high", Rarity.HIGH, result)
    }

    @Test
    fun testEvaluateRarity_withEndangeredSpecies_returnsCriticalRarity() {
        val species = Species("Amur Leopard", "endangered", 0.001)
        val result = evaluateRarityUseCase.evaluate(species)
        assertEquals("Expected rarity to be critical", Rarity.CRITICAL, result)
    }
}