package com.example.elixi.news_1.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shmulik on 30 נובמבר 2017.
 */

public class Source {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", name = "+name+"]";
    }
}