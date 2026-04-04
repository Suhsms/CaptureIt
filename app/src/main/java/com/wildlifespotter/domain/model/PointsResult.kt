data class PointsResult(
    val speciesName: String,
    val rarityScore: Int,
    val photoQualityScore: Int,
    val totalPoints: Int
) {
    companion object {
        fun calculateTotalPoints(rarityScore: Int, photoQualityScore: Int): Int {
            return rarityScore + photoQualityScore
        }
    }
}