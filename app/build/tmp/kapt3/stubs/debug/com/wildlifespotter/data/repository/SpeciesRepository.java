package com.wildlifespotter.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\f\u0010\u0015\u001a\u00020\u0007*\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/wildlifespotter/data/repository/SpeciesRepository;", "", "speciesDao", "Lcom/wildlifespotter/data/local/dao/SpeciesDao;", "(Lcom/wildlifespotter/data/local/dao/SpeciesDao;)V", "getAllSpecies", "", "Lcom/wildlifespotter/domain/model/Species;", "getRarityScore", "", "speciesId", "", "getSpeciesById", "id", "", "getSpeciesByName", "name", "saveSpecies", "", "species", "Lcom/wildlifespotter/data/local/entity/SpeciesEntity;", "toSpecies", "app_debug"})
public final class SpeciesRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.wildlifespotter.data.local.dao.SpeciesDao speciesDao = null;
    
    @javax.inject.Inject()
    public SpeciesRepository(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.dao.SpeciesDao speciesDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wildlifespotter.domain.model.Species getSpeciesById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.wildlifespotter.domain.model.Species getSpeciesByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.wildlifespotter.domain.model.Species> getAllSpecies() {
        return null;
    }
    
    public final void saveSpecies(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.entity.SpeciesEntity species) {
    }
    
    public final int getRarityScore(@org.jetbrains.annotations.NotNull()
    java.lang.String speciesId) {
        return 0;
    }
    
    private final com.wildlifespotter.domain.model.Species toSpecies(com.wildlifespotter.data.local.entity.SpeciesEntity $this$toSpecies) {
        return null;
    }
}