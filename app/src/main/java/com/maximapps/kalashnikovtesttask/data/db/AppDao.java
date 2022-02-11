package com.maximapps.kalashnikovtesttask.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.maximapps.kalashnikovtesttask.data.db.models.AuthorEntity;
import com.maximapps.kalashnikovtesttask.data.db.models.BookEntity;

import java.util.List;

@Dao
public interface AppDao {
    @Query("SELECT * FROM Book")
    LiveData<List<BookEntity>> fetchBooks();

    @Query("SELECT * FROM BOOK WHERE id = :id")
    LiveData<BookEntity> fetchBookById(int id);

    @Query("SELECT * FROM Author WHERE id = :id")
    LiveData<AuthorEntity> findAuthorById(int id);

    @Query("UPDATE BOOK SET description = :description WHERE id = :id")
    void updateBookDescriptionById(int id, String description);
}
