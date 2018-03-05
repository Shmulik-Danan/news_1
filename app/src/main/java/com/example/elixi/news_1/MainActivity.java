package com.example.elixi.news_1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.elixi.news_1.models.Articles;
import com.example.elixi.news_1.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<Articles> articlesArrayList;

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    MyAdapter adapter;
    private SwipeRefreshLayout swipeContainer;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();

        ((MVVMApplication) this.getApplication())
                .getApplicationComponent()
                .inject(this);

        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MainActivityViewModel.class);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        adapter = new MyAdapter(this);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);

        subscribeRoom();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                subscribeRetrofit();
                subscribeRoom();
                swipeContainer.setRefreshing(false);

            }
        });
    }

    private void subscribeRoom() {
        mainActivityViewModel.getListItemsObservable().observe(this, new Observer<List<Articles>>() {
            @Override
            public void onChanged(@Nullable List<Articles> articles) {
                if (articles.toString() == "[]") {
                    Log.d(TAG, "onChanged: articles = '[]' ");
                    subscribeRetrofit();
                }
                Log.d(TAG, "onChanged: articles = "+articles);
                save(articles);
            }
        });

    }

    private void subscribeRetrofit() {
        final Observer<ArrayList<Articles>> articles = new Observer<ArrayList<Articles>>() {

            @Override
            public void onChanged(@Nullable ArrayList<Articles> articles) {
                if (articles != null && articles != articlesArrayList) {
                    mainActivityViewModel.set(articles);

                    Log.d(TAG, "articles: " + articles);
                    Log.d(TAG, "rrayList: " + articlesArrayList);


                }
                else Log.d(TAG, "subscribeRetrofit: Something went wrong with the Retrofit connection");
            }
        };
        mainActivityViewModel.getArticlesListObservable().observe(this, articles);
    }

    private void save(List<Articles> articles) {
        this.articlesArrayList = articles;
        Log.d(TAG, "save: articles = "+articles);
        RecyclerView();

    }

    void RecyclerView() {
        adapter.setArticles((ArrayList<Articles>) articlesArrayList);
        recyclerView.setAdapter(adapter);
    }



}
