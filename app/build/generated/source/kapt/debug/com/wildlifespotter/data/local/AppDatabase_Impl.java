package com.wildlifespotter.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.wildlifespotter.data.local.dao.SightingDao;
import com.wildlifespotter.data.local.dao.SightingDao_Impl;
import com.wildlifespotter.data.local.dao.SpeciesDao;
import com.wildlifespotter.data.local.dao.SpeciesDao_Impl;
import com.wildlifespotter.data.local.dao.UserDao;
import com.wildlifespotter.data.local.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile SpeciesDao _speciesDao;

  private volatile SightingDao _sightingDao;

  private volatile UserDao _userDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `species` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `scientificName` TEXT NOT NULL, `rarity` TEXT NOT NULL, `photoQuality` INTEGER NOT NULL, `location` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `sightings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `speciesId` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `location` TEXT NOT NULL, `photoUrl` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `rarityPoints` INTEGER NOT NULL, `photoQualityScore` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `points` INTEGER NOT NULL, `location` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dc9f1a053013b5740c532a5bcc3dfa1e')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `species`");
        _db.execSQL("DROP TABLE IF EXISTS `sightings`");
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSpecies = new HashMap<String, TableInfo.Column>(6);
        _columnsSpecies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpecies.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpecies.put("scientificName", new TableInfo.Column("scientificName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpecies.put("rarity", new TableInfo.Column("rarity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpecies.put("photoQuality", new TableInfo.Column("photoQuality", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSpecies.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSpecies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSpecies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSpecies = new TableInfo("species", _columnsSpecies, _foreignKeysSpecies, _indicesSpecies);
        final TableInfo _existingSpecies = TableInfo.read(_db, "species");
        if (! _infoSpecies.equals(_existingSpecies)) {
          return new RoomOpenHelper.ValidationResult(false, "species(com.wildlifespotter.data.local.entity.SpeciesEntity).\n"
                  + " Expected:\n" + _infoSpecies + "\n"
                  + " Found:\n" + _existingSpecies);
        }
        final HashMap<String, TableInfo.Column> _columnsSightings = new HashMap<String, TableInfo.Column>(8);
        _columnsSightings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("speciesId", new TableInfo.Column("speciesId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("rarityPoints", new TableInfo.Column("rarityPoints", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSightings.put("photoQualityScore", new TableInfo.Column("photoQualityScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSightings = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSightings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSightings = new TableInfo("sightings", _columnsSightings, _foreignKeysSightings, _indicesSightings);
        final TableInfo _existingSightings = TableInfo.read(_db, "sightings");
        if (! _infoSightings.equals(_existingSightings)) {
          return new RoomOpenHelper.ValidationResult(false, "sightings(com.wildlifespotter.data.local.entity.SightingEntity).\n"
                  + " Expected:\n" + _infoSightings + "\n"
                  + " Found:\n" + _existingSightings);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(4);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("points", new TableInfo.Column("points", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.wildlifespotter.data.local.entity.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dc9f1a053013b5740c532a5bcc3dfa1e", "90fb4e321e8274223f1e3f4f7dfacff9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "species","sightings","users");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `species`");
      _db.execSQL("DELETE FROM `sightings`");
      _db.execSQL("DELETE FROM `users`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SpeciesDao.class, SpeciesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SightingDao.class, SightingDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SpeciesDao speciesDao() {
    if (_speciesDao != null) {
      return _speciesDao;
    } else {
      synchronized(this) {
        if(_speciesDao == null) {
          _speciesDao = new SpeciesDao_Impl(this);
        }
        return _speciesDao;
      }
    }
  }

  @Override
  public SightingDao sightingDao() {
    if (_sightingDao != null) {
      return _sightingDao;
    } else {
      synchronized(this) {
        if(_sightingDao == null) {
          _sightingDao = new SightingDao_Impl(this);
        }
        return _sightingDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
