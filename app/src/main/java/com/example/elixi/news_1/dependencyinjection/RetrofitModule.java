package com.example.elixi.news_1.dependencyinjection;

import android.app.Application;

import com.example.elixi.news_1.services.APIService;
import com.example.elixi.news_1.services.RetrofitRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shmulik on 15 פברואר 2018.
 */

@Module
public class RetrofitModule {
    private APIService gitHubService;


    public RetrofitModule() {
        gitHubService = new Retrofit.Builder()
                .baseUrl(APIService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class);

    }


    @Provides
    @Singleton
    RetrofitRepository provideProjectRepository(APIService gitHubService) {
        return new RetrofitRepository(gitHubService);
    }


    @Singleton
    @Provides
    APIService provideGithubService(Application application) {
        return gitHubService;
    }

/*
    @Provides
    @Singleton
    ViewModel provideViewModel(RetrofitRepository repository){
        return new RetrofitViewModel(repository);
    }*/

}
