package com.wildlifespotter.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wildlifespotter/domain/usecase/EvaluateRarityUseCase;", "", "speciesRepository", "Lcom/wildlifespotter/data/repository/SpeciesRepository;", "(Lcom/wildlifespotter/data/repository/SpeciesRepository;)V", "calculatePoints", "", "rarityScore", "photoQuality", "evaluateRarity", "Lcom/wildlifespotter/domain/model/PointsResult;", "speciesId", "", "speciesName", "app_debug"})
public final class EvaluateRarityUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.data.repository.SpeciesRepository speciesRepository = null;
    
    @javax.inject.Inject()
    public EvaluateRarityUseCase(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.repository.SpeciesRepository speciesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wildlifespotter.domain.model.PointsResult evaluateRarity(@org.jetbrains.annotations.NotNull()
    java.lang.String speciesId, int photoQuality, @org.jetbrains.annotations.NotNull()
    java.lang.String speciesName) {
        return null;
    }
    
    private final int calculatePoints(int rarityScore, int photoQuality) {
        return 0;
    }
}