package com.maximapps.kalashnikovtesttask.data.db.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Author")
public class AuthorEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int id;
    @NonNull
    @ColumnInfo(name = "name")
    private final String name;
    @NonNull
    @ColumnInfo(name = "birth_date")
    private final Date birthDate;

    public AuthorEntity(int id, @NonNull String name, @NonNull Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Date getBirthDate() {
        return birthDate;
    }
}
