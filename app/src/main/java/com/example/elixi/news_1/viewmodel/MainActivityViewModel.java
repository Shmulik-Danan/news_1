package com.example.elixi.news_1.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.elixi.news_1.models.Articles;
import com.example.elixi.news_1.models.ArticlesRepository;
import com.example.elixi.news_1.services.RetrofitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Shmulik on 27 פברואר 2018.
 */
@Singleton
public class MainActivityViewModel extends ViewModel{
    private final LiveData<List<Articles>> ListItemsObservable;
    private final LiveData<ArrayList<Articles>> ArticlesListObservable;

    private ArticlesRepository repository;
    private RetrofitRepository retrofitRepository ;

    @Inject
    public MainActivityViewModel(ArticlesRepository repository, RetrofitRepository retrofitRepository,
     @NonNull Application application) {
        this.repository = repository;
        this.retrofitRepository = retrofitRepository;
        ArticlesListObservable = this.retrofitRepository.get("top-headlines","d6c8fed938d34d42860ff2376b4dcdbe"
                ,"google-news-is","");

        ListItemsObservable =repository.getListItem();
    }



    public LiveData<ArrayList<Articles>> getArticlesListObservable() {
        return this.retrofitRepository.get("top-headlines","d6c8fed938d34d42860ff2376b4dcdbe"
                ,"google-news-is","");
       // return ArticlesListObservable;
    }

    public LiveData<List<Articles>> getListItemsObservable() {
        return ListItemsObservable;

        //return repository.getListItem();
    }

    public boolean set(ArrayList<Articles> articlesList){
        add addTask = new add();
        addTask.execute(articlesList);
        return true;
        //repository.createNewListItem(articlesList);
    }


    private class add extends AsyncTask<ArrayList<Articles>, Void, Void> {

        @Override
        protected Void doInBackground(ArrayList<Articles>[] articles) {
            repository.createNewListItem(articles[0]);

            return null;
        }
    }


    public void deleteListItem() {
        //repository.deleteListItem();
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute();
    }

    private class DeleteItemTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            repository.deleteListItem();
            return null;
        }
    }


}

