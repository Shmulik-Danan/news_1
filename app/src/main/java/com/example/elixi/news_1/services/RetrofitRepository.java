package com.example.elixi.news_1.services;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.elixi.news_1.models.Articles;
import com.example.elixi.news_1.models.SearchResult;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class RetrofitRepository {
    private APIService apiService;

    @Inject
    public RetrofitRepository(APIService apiService ) {
        this.apiService = apiService;
    }

    public MutableLiveData<ArrayList<Articles>> get(String GET, String apiKey, String sources, String language) {
        final MutableLiveData<ArrayList<Articles>> data = new MutableLiveData<>();



        apiService.get("https://newsapi.org/v2/top-headlines?country=il&apiKey=d6c8fed938d34d42860ff2376b4dcdbe").enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                Log.d("", "onResponse: ");

                data.setValue(response.body().getArticles());
                Log.d("", "onResponse: "+response.body().getArticles());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                data.setValue(null);
                Log.d("", "onFailure: null");

            }
        });
        return data;
    }

}
