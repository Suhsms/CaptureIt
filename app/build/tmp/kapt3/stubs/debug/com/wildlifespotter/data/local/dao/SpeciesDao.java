package com.wildlifespotter.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/wildlifespotter/data/local/dao/SpeciesDao;", "", "deleteAllSpecies", "", "getAllSpecies", "", "Lcom/wildlifespotter/data/local/entity/SpeciesEntity;", "getSpeciesById", "id", "", "insertSpecies", "species", "app_debug"})
@androidx.room.Dao()
public abstract interface SpeciesDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertSpecies(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.entity.SpeciesEntity species);
    
    @androidx.room.Query(value = "SELECT * FROM species WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract com.wildlifespotter.data.local.entity.SpeciesEntity getSpeciesById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Query(value = "SELECT * FROM species")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.wildlifespotter.data.local.entity.SpeciesEntity> getAllSpecies();
    
    @androidx.room.Query(value = "DELETE FROM species")
    public abstract void deleteAllSpecies();
}