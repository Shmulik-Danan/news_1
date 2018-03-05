package com.example.elixi.news_1.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Shmulik on 30 נובמבר 2017.
 */
@Entity
public class Articles {
    @PrimaryKey
    @SerializedName("title")
    @NonNull
    private String title;
    @ColumnInfo(name="publishedAt")
    @SerializedName("publishedAt")
    private String publishedAt;

    @ColumnInfo(name="author")
    @SerializedName("author")
    private String author;

    @ColumnInfo(name="urlToImage")
    @SerializedName("urlToImage")
    private String urlToImage;

    @Ignore
    @SerializedName("source")
    private Source source;

    @ColumnInfo(name="description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name="url")
    @SerializedName("url")
    private String url;

    public String getPublishedAt ()
    {
        /*String ans="";
        for(int i=0;i<publishedAt.length()-6;i++){
            if(publishedAt.charAt(i)=="T".charAt(0)){
                ans+=" ";

            }
            else  ans+=publishedAt.charAt(i);
        }*/
        return publishedAt;
    }

    public void setPublishedAt (String publishedAt)
    {


        this.publishedAt = publishedAt;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }


    public String getUrlToImage ()
    {

        return urlToImage;
    }

    public void setUrlToImage (String urlToImage)
    {
        this.urlToImage = urlToImage;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Source getSource ()
    {
        return source;
    }

    public void setSource (Source source)
    {
        this.source = source;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [publishedAt = "+publishedAt+", author = "+author+", urlToImage = "+urlToImage+", title = "+title+", source = "+source+", description = "+description+", url = "+url+"]";
    }


}
