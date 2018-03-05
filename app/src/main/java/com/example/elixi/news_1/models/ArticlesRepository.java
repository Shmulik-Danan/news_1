package com.example.elixi.news_1.models;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

/**
 * Created by Shmulik on 15 פברואר 2018.
 */

public class ArticlesRepository {
    private final articlesDao articlesDao ;

    @Inject
    public ArticlesRepository(articlesDao listItemDao){
        this.articlesDao = listItemDao;
    }



    public LiveData<List<Articles>> getListItem(){
        return articlesDao.getall();
    }

    public void createNewListItem(ArrayList<Articles> articlesList){
        articlesDao.deleteAll();
        articlesDao.insertAll(articlesList.toArray(new Articles[articlesList.size()]));
    }

    public void deleteListItem(){
        articlesDao.deleteAll();
    }



}
