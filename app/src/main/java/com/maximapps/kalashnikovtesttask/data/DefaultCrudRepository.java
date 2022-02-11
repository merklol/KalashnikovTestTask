package com.maximapps.kalashnikovtesttask.data;

import static androidx.lifecycle.Transformations.map;
import static androidx.lifecycle.Transformations.switchMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.maximapps.kalashnikovtesttask.data.db.AppDao;
import com.maximapps.kalashnikovtesttask.data.db.models.AuthorEntity;
import com.maximapps.kalashnikovtesttask.data.db.models.BookEntity;
import com.maximapps.kalashnikovtesttask.domain.CrudRepository;
import com.maximapps.kalashnikovtesttask.domain.models.Book;
import com.maximapps.kalashnikovtesttask.domain.models.BookDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class DefaultCrudRepository implements CrudRepository {
    private final AppDao appDao;
    private final ExecutorService executorService;

    public DefaultCrudRepository(AppDao appDao, ExecutorService executorService) {
        this.appDao = appDao;
        this.executorService = executorService;
    }

    @Override
    public LiveData<List<Book>> fetchBooks() {
        return Transformations.map(appDao.fetchBooks(), books -> {
            List<Book> list = new ArrayList<>();
            for (BookEntity entity : books) {
                list.add(new Book(entity.getId(), entity.getName(), entity.getDescription()));
            }
            return list;
        });
    }

    @Override
    public LiveData<BookDetails> fetchBookDetailsById(int id) {
        LiveData<BookEntity> result = appDao.fetchBookById(id);
        if (result == null) return new MutableLiveData<>(BookDetails.empty());
        return switchMap(appDao.fetchBookById(id), book ->
                map(appDao.findAuthorById(book.getAuthorId()), author -> mapToBookDetails(book, author))
        );
    }

    @Override
    public void updateBookDescriptionById(int id, String description) {
        executorService.execute(() -> appDao.updateBookDescriptionById(id, description));
    }

    private BookDetails mapToBookDetails(BookEntity bookEntity, AuthorEntity authorEntity) {
        return new BookDetails(
                bookEntity.getName(),
                authorEntity.getName(),
                bookEntity.getDescription(),
                authorEntity.getBirthDate()
        );
    }
}
