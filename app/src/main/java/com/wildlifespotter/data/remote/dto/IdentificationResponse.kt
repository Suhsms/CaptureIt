data class IdentificationResponse(
    val speciesName: String,
    val commonName: String?,
    val scientificName: String?,
    val imageUrl: String?,
    val confidence: Float,
    val rarityScore: Int
)