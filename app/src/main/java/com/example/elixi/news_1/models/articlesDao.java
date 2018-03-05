package com.example.elixi.news_1.models;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Shmulik on 07 דצמבר 2017.
 */
@Dao
public interface articlesDao {

    @Query("SELECT * FROM articles")
    LiveData<List<Articles>>  getall();

    @Insert
    void insertAll(Articles... articles);

    @Query("DELETE FROM articles")
    void deleteAll();

}
