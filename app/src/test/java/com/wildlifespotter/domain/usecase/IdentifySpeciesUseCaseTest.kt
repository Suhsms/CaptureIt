import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import com.wildlifespotter.domain.usecase.IdentifySpeciesUseCase
import com.wildlifespotter.data.repository.SpeciesRepository

class IdentifySpeciesUseCaseTest {

    private lateinit var identifySpeciesUseCase: IdentifySpeciesUseCase
    private lateinit var speciesRepository: SpeciesRepository

    @Before
    fun setUp() {
        speciesRepository = mock(SpeciesRepository::class.java)
        identifySpeciesUseCase = IdentifySpeciesUseCase(speciesRepository)
    }

    @Test
    fun `test identify species returns correct species`() {
        val imageUri = "test_image_uri"
        val expectedSpecies = "Test Species"
        
        `when`(speciesRepository.identifySpecies(imageUri)).thenReturn(expectedSpecies)

        val result = identifySpeciesUseCase.execute(imageUri)

        assertEquals(expectedSpecies, result)
    }

    @Test
    fun `test identify species returns null for unknown species`() {
        val imageUri = "unknown_image_uri"
        
        `when`(speciesRepository.identifySpecies(imageUri)).thenReturn(null)

        val result = identifySpeciesUseCase.execute(imageUri)

        assertEquals(null, result)
    }
}