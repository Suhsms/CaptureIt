package com.wildlifespotter.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wildlifespotter/domain/usecase/CalculatePointsUseCase;", "", "()V", "calculateQualityPoints", "", "photoQuality", "", "calculateRarityPoints", "rarity", "", "execute", "Lcom/wildlifespotter/domain/model/PointsResult;", "sighting", "Lcom/wildlifespotter/domain/model/Sighting;", "executeForSpecies", "species", "Lcom/wildlifespotter/domain/model/Species;", "app_debug"})
public final class CalculatePointsUseCase {
    
    @javax.inject.Inject()
    public CalculatePointsUseCase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wildlifespotter.domain.model.PointsResult execute(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.model.Sighting sighting) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wildlifespotter.domain.model.PointsResult executeForSpecies(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.model.Species species, float photoQuality) {
        return null;
    }
    
    private final int calculateRarityPoints(java.lang.String rarity) {
        return 0;
    }
    
    private final int calculateQualityPoints(float photoQuality) {
        return 0;
    }
}