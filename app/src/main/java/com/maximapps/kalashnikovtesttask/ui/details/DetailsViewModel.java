package com.maximapps.kalashnikovtesttask.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maximapps.kalashnikovtesttask.domain.CrudRepository;
import com.maximapps.kalashnikovtesttask.domain.models.BookDetails;

import javax.inject.Inject;

public class DetailsViewModel extends ViewModel {
    private final CrudRepository crudRepository;

    @Inject
    public DetailsViewModel(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public LiveData<BookDetails> fetchBookById(int id) {
        return crudRepository.fetchBookDetailsById(id);
    }
}
