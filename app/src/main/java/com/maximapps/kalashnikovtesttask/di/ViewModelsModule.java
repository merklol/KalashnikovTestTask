package com.maximapps.kalashnikovtesttask.di;

import androidx.lifecycle.ViewModel;

import com.maximapps.kalashnikovtesttask.di.viewmodel.ViewModelKey;
import com.maximapps.kalashnikovtesttask.ui.details.DetailsViewModel;
import com.maximapps.kalashnikovtesttask.ui.edit.EditViewModel;
import com.maximapps.kalashnikovtesttask.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
@SuppressWarnings("unused")
public abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel.class)
    public abstract ViewModel bindDetailsViewModel(DetailsViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(EditViewModel.class)
    public abstract ViewModel bindEditViewModel(EditViewModel viewModel);
}
