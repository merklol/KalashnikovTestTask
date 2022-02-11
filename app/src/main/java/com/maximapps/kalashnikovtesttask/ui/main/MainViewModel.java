package com.maximapps.kalashnikovtesttask.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maximapps.kalashnikovtesttask.domain.CrudRepository;
import com.maximapps.kalashnikovtesttask.domain.models.Book;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    private final CrudRepository crudRepository;

    @Inject
    public MainViewModel(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public LiveData<List<Book>> fetchBooks() {
        return crudRepository.fetchBooks();
    }
}
