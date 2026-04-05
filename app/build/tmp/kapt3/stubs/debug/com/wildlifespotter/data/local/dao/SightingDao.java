package com.wildlifespotter.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\'\u00a8\u0006\r"}, d2 = {"Lcom/wildlifespotter/data/local/dao/SightingDao;", "", "deleteSightingById", "", "sightingId", "", "getSightingById", "Lcom/wildlifespotter/data/local/entity/SightingEntity;", "getSightingsByUserId", "", "userId", "insertSighting", "sighting", "app_debug"})
@androidx.room.Dao()
public abstract interface SightingDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertSighting(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.entity.SightingEntity sighting);
    
    @androidx.room.Query(value = "SELECT * FROM sightings WHERE userId = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.wildlifespotter.data.local.entity.SightingEntity> getSightingsByUserId(long userId);
    
    @androidx.room.Query(value = "SELECT * FROM sightings WHERE id = :sightingId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract com.wildlifespotter.data.local.entity.SightingEntity getSightingById(long sightingId);
    
    @androidx.room.Query(value = "DELETE FROM sightings WHERE id = :sightingId")
    public abstract void deleteSightingById(long sightingId);
}