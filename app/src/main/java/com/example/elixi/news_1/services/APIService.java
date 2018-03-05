package com.example.elixi.news_1.services;

import com.example.elixi.news_1.models.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    String HTTPS_API_GITHUB_URL = "https://newsapi.org/v2/";

    @GET("{GET}")
    Call<SearchResult> get(@Path("GET") String GET, @Query("apiKey") String apiKey, @Query("sources") String sources,
                           @Query("language") String language);

    }
