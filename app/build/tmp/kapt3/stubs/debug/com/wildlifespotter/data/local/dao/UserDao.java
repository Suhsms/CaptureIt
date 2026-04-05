package com.wildlifespotter.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/wildlifespotter/data/local/dao/UserDao;", "", "getAllUsers", "", "Lcom/wildlifespotter/data/local/entity/UserEntity;", "getUserById", "userId", "", "insertUser", "", "user", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertUser(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.data.local.entity.UserEntity user);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE id = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract com.wildlifespotter.data.local.entity.UserEntity getUserById(long userId);
    
    @androidx.room.Query(value = "SELECT * FROM users")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.wildlifespotter.data.local.entity.UserEntity> getAllUsers();
}