import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import com.wildlifespotter.data.repository.SpeciesRepository
import com.wildlifespotter.data.local.dao.SpeciesDao
import com.wildlifespotter.domain.model.Species

class SpeciesRepositoryTest {

    private lateinit var speciesDao: SpeciesDao
    private lateinit var speciesRepository: SpeciesRepository

    @Before
    fun setUp() {
        speciesDao = mock(SpeciesDao::class.java)
        speciesRepository = SpeciesRepository(speciesDao)
    }

    @Test
    fun testGetSpeciesById() {
        val species = Species(id = 1, name = "Test Species", rarity = "Common")
        `when`(speciesDao.getSpeciesById(1)).thenReturn(species)

        val result = speciesRepository.getSpeciesById(1)

        assertEquals(species, result)
    }

    @Test
    fun testGetAllSpecies() {
        val speciesList = listOf(
            Species(id = 1, name = "Test Species 1", rarity = "Common"),
            Species(id = 2, name = "Test Species 2", rarity = "Rare")
        )
        `when`(speciesDao.getAllSpecies()).thenReturn(speciesList)

        val result = speciesRepository.getAllSpecies()

        assertEquals(speciesList, result)
    }
}