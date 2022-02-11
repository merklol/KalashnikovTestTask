package com.maximapps.kalashnikovtesttask.data.db.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "Book",
        foreignKeys = {
                @ForeignKey(
                        entity = AuthorEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"authorId"}
                )
        },
        indices = {@Index(value = {"authorId"})}
)
public class BookEntity {
    @PrimaryKey
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final String description;
    private final int authorId;

    public BookEntity(int id, @NonNull String name, @NonNull String description, int authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public int getAuthorId() {
        return authorId;
    }
}
