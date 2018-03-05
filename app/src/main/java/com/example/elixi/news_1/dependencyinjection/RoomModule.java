/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

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
