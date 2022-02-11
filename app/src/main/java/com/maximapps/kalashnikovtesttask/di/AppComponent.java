package com.maximapps.kalashnikovtesttask.di;

import android.app.Application;

import com.maximapps.kalashnikovtesttask.App;
import com.maximapps.kalashnikovtesttask.di.viewmodel.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        FragmentModule.class,
        ViewModelFactoryModule.class,
        ViewModelsModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
