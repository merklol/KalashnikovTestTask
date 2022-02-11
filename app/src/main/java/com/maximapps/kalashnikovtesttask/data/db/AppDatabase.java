package com.maximapps.kalashnikovtesttask.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.maximapps.kalashnikovtesttask.data.db.converters.DateConverter;
import com.maximapps.kalashnikovtesttask.data.db.models.AuthorEntity;
import com.maximapps.kalashnikovtesttask.data.db.models.BookEntity;

@Database(entities = {BookEntity.class, AuthorEntity.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}
