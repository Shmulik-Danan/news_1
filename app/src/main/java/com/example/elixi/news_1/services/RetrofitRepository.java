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

        apiService.get(GET, apiKey, sources, language).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                data.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;
    }

}
