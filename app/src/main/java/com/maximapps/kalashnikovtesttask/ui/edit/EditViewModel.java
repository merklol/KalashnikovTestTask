package com.maximapps.kalashnikovtesttask.ui.edit;

import androidx.lifecycle.ViewModel;

import com.maximapps.kalashnikovtesttask.domain.CrudRepository;

import javax.inject.Inject;

public class EditViewModel extends ViewModel {
    private final CrudRepository crudRepository;

    @Inject
    public EditViewModel(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public void updateBookDescriptionById(int id, String description) {
        crudRepository.updateBookDescriptionById(id, description);
    }
}
