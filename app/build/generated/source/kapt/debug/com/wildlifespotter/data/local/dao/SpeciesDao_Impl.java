package com.wildlifespotter.data.local.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wildlifespotter.data.local.entity.SpeciesEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SpeciesDao_Impl implements SpeciesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SpeciesEntity> __insertionAdapterOfSpeciesEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSpecies;

  public SpeciesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSpeciesEntity = new EntityInsertionAdapter<SpeciesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `species` (`id`,`name`,`scientificName`,`rarity`,`photoQuality`,`location`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SpeciesEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getScientificName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getScientificName());
        }
        if (value.getRarity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRarity());
        }
        stmt.bindLong(5, value.getPhotoQuality());
        if (value.getLocation() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLocation());
        }
      }
    };
    this.__preparedStmtOfDeleteAllSpecies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM species";
        return _query;
      }
    };
  }

  @Override
  public void insertSpecies(final SpeciesEntity species) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSpeciesEntity.insert(species);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSpecies() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSpecies.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSpecies.release(_stmt);
    }
  }

  @Override
  public SpeciesEntity getSpeciesById(final String id) {
    final String _sql = "SELECT * FROM species WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfPhotoQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "photoQuality");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final SpeciesEntity _result;
      if(_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpScientificName;
        if (_cursor.isNull(_cursorIndexOfScientificName)) {
          _tmpScientificName = null;
        } else {
          _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
        }
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        final int _tmpPhotoQuality;
        _tmpPhotoQuality = _cursor.getInt(_cursorIndexOfPhotoQuality);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _result = new SpeciesEntity(_tmpId,_tmpName,_tmpScientificName,_tmpRarity,_tmpPhotoQuality,_tmpLocation);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SpeciesEntity> getAllSpecies() {
    final String _sql = "SELECT * FROM species";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
      final int _cursorIndexOfRarity = CursorUtil.getColumnIndexOrThrow(_cursor, "rarity");
      final int _cursorIndexOfPhotoQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "photoQuality");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final List<SpeciesEntity> _result = new ArrayList<SpeciesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SpeciesEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpScientificName;
        if (_cursor.isNull(_cursorIndexOfScientificName)) {
          _tmpScientificName = null;
        } else {
          _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
        }
        final String _tmpRarity;
        if (_cursor.isNull(_cursorIndexOfRarity)) {
          _tmpRarity = null;
        } else {
          _tmpRarity = _cursor.getString(_cursorIndexOfRarity);
        }
        final int _tmpPhotoQuality;
        _tmpPhotoQuality = _cursor.getInt(_cursorIndexOfPhotoQuality);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _item = new SpeciesEntity(_tmpId,_tmpName,_tmpScientificName,_tmpRarity,_tmpPhotoQuality,_tmpLocation);
        _result.add(_item);
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
