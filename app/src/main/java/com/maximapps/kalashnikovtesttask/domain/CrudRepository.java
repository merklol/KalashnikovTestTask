package com.maximapps.kalashnikovtesttask.domain;

import androidx.lifecycle.LiveData;

import com.maximapps.kalashnikovtesttask.domain.models.Book;
import com.maximapps.kalashnikovtesttask.domain.models.BookDetails;

import java.util.List;

public interface CrudRepository {
    LiveData<List<Book>> fetchBooks();
    LiveData<BookDetails> fetchBookDetailsById(int id);
    void updateBookDescriptionById(int id, String description);
}
