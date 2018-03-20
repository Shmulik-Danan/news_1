

package com.example.elixi.news_1.dependencyinjection;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.example.elixi.news_1.models.AppDatabase;
import com.example.elixi.news_1.models.ArticlesRepository;
import com.example.elixi.news_1.models.articlesDao;
import com.example.elixi.news_1.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(subcomponents = ViewModelSubComponent.class)
public class RoomModule {

    private final AppDatabase database;

    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(
                application,
                AppDatabase.class,
                "ArticlesDb.db"
        ).build();
    }

    @Provides
    @Singleton
    ArticlesRepository provideListItemRepository(articlesDao articlesDao){
        return new ArticlesRepository(articlesDao);
    }

    @Provides
    @Singleton
    articlesDao provideListItemDao(AppDatabase database){
        return database.articlesDao();
    }

    @Provides
    @Singleton
    AppDatabase provideListItemDatabase(Application application){
        return database;
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new CustomViewModelFactory(viewModelSubComponent.build());

    }
}
