package com.example.elixi.news_1.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Shmulik on 29 נובמבר 2017.
 */

public class SearchResult {
    @SerializedName("articles")
    private ArrayList<Articles> articles;
    @SerializedName("status")
    private String status;

    public ArrayList<Articles> getArticles ()
    {
        return articles;
    }

    public void setArticles ( ArrayList<Articles> articles)
    {
        this.articles = articles;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [articles = "+articles+", status = "+status+"]";
    }
}
