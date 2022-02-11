package com.maximapps.kalashnikovtesttask.di;

import com.maximapps.kalashnikovtesttask.ui.details.DetailsFragment;
import com.maximapps.kalashnikovtesttask.ui.edit.EditFragment;
import com.maximapps.kalashnikovtesttask.ui.main.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
@SuppressWarnings("unused")
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();

    @ContributesAndroidInjector
    abstract DetailsFragment contributeDetailsFragment();

    @ContributesAndroidInjector
    abstract EditFragment contributeEditFragment();
}