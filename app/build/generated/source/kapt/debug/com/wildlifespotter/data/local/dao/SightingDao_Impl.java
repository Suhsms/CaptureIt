package com.wildlifespotter.data.local.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wildlifespotter.data.local.entity.SightingEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SightingDao_Impl implements SightingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SightingEntity> __insertionAdapterOfSightingEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSightingById;

  public SightingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSightingEntity = new EntityInsertionAdapter<SightingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `sightings` (`id`,`speciesId`,`userId`,`location`,`photoUrl`,`timestamp`,`rarityPoints`,`photoQualityScore`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SightingEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSpeciesId());
        stmt.bindLong(3, value.getUserId());
        if (value.getLocation() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLocation());
        }
        if (value.getPhotoUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPhotoUrl());
        }
        stmt.bindLong(6, value.getTimestamp());
        stmt.bindLong(7, value.getRarityPoints());
        stmt.bindLong(8, value.getPhotoQualityScore());
      }
    };
    this.__preparedStmtOfDeleteSightingById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM sightings WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertSighting(final SightingEntity sighting) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSightingEntity.insert(sighting);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSightingById(final long sightingId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSightingById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, sightingId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSightingById.release(_stmt);
    }
  }

  @Override
  public List<SightingEntity> getSightingsByUserId(final long userId) {
    final String _sql = "SELECT * FROM sightings WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSpeciesId = CursorUtil.getColumnIndexOrThrow(_cursor, "speciesId");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfRarityPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "rarityPoints");
      final int _cursorIndexOfPhotoQualityScore = CursorUtil.getColumnIndexOrThrow(_cursor, "photoQualityScore");
      final List<SightingEntity> _result = new ArrayList<SightingEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SightingEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpSpeciesId;
        _tmpSpeciesId = _cursor.getLong(_cursorIndexOfSpeciesId);
        final long _tmpUserId;
        _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final String _tmpPhotoUrl;
        if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
          _tmpPhotoUrl = null;
        } else {
          _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
        }
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final int _tmpRarityPoints;
        _tmpRarityPoints = _cursor.getInt(_cursorIndexOfRarityPoints);
        final int _tmpPhotoQualityScore;
        _tmpPhotoQualityScore = _cursor.getInt(_cursorIndexOfPhotoQualityScore);
        _item = new SightingEntity(_tmpId,_tmpSpeciesId,_tmpUserId,_tmpLocation,_tmpPhotoUrl,_tmpTimestamp,_tmpRarityPoints,_tmpPhotoQualityScore);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SightingEntity getSightingById(final long sightingId) {
    final String _sql = "SELECT * FROM sightings WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sightingId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSpeciesId = CursorUtil.getColumnIndexOrThrow(_cursor, "speciesId");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfRarityPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "rarityPoints");
      final int _cursorIndexOfPhotoQualityScore = CursorUtil.getColumnIndexOrThrow(_cursor, "photoQualityScore");
      final SightingEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpSpeciesId;
        _tmpSpeciesId = _cursor.getLong(_cursorIndexOfSpeciesId);
        final long _tmpUserId;
        _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        final String _tmpPhotoUrl;
        if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
          _tmpPhotoUrl = null;
        } else {
          _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
        }
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final int _tmpRarityPoints;
        _tmpRarityPoints = _cursor.getInt(_cursorIndexOfRarityPoints);
        final int _tmpPhotoQualityScore;
        _tmpPhotoQualityScore = _cursor.getInt(_cursorIndexOfPhotoQualityScore);
        _result = new SightingEntity(_tmpId,_tmpSpeciesId,_tmpUserId,_tmpLocation,_tmpPhotoUrl,_tmpTimestamp,_tmpRarityPoints,_tmpPhotoQualityScore);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
