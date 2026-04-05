package com.wildlifespotter.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wildlifespotter/data/repository/SightingRepository;", "", "sightingDao", "Lcom/wildlifespotter/data/local/dao/SightingDao;", "(Lcom/wildlifespotter/data/local/dao/SightingDao;)V", "getAllSightings", "", "Lcom/wildlifespotter/domain/model/Sighting;", "getSightingsByUserId", "userId", "", "saveSighting", "", "sighting", "app_debug"})
public final class SightingRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.data.local.dao.SightingDao sightingDao = null;
    
    @javax.inject.Inject()
    public SightingRepository(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.dao.SightingDao sightingDao) {
        super();
    }
    
    public final void saveSighting(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.domain.model.Sighting sighting) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wildlifespotter.domain.model.Sighting> getSightingsByUserId(long userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wildlifespotter.domain.model.Sighting> getAllSightings() {
        return null;
    }
}