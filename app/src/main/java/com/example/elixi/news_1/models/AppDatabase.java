package com.example.elixi.news_1.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Shmulik on 08 דצמבר 2017.
 */

@Database(entities = {Articles.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
    //private static AppDatabase singleton;
    public static final String DATABASE_NAME = "ArticlesDb.db";

    public abstract articlesDao articlesDao();


    }


