package com.maximapps.kalashnikovtesttask.di;

import android.app.Application;

import androidx.room.Room;

import com.maximapps.kalashnikovtesttask.data.DefaultCrudRepository;
import com.maximapps.kalashnikovtesttask.data.db.AppDatabase;
import com.maximapps.kalashnikovtesttask.domain.CrudRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public ExecutorService provideExecutorService() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    public AppDatabase provideRoomDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                AppDatabase.class, "app_database.db")
                .createFromAsset("app_database.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public CrudRepository provideCrudRepository(AppDatabase appDatabase, ExecutorService executorService) {
        return new DefaultCrudRepository(appDatabase.appDao(), executorService);
    }
}
