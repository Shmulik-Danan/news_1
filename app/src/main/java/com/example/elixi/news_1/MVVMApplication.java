package com.example.elixi.news_1;

import android.app.Application;
import android.util.Log;

import com.example.elixi.news_1.dependencyinjection.ApplicationComponent;
import com.example.elixi.news_1.dependencyinjection.ApplicationModule;
import com.example.elixi.news_1.dependencyinjection.DaggerApplicationComponent;
import com.example.elixi.news_1.dependencyinjection.RetrofitModule;
import com.example.elixi.news_1.dependencyinjection.RoomModule;

import static android.content.ContentValues.TAG;

/**
 * Created by Shmulik on 15 פברואר 2018.
 */

public class MVVMApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
        Log.e(TAG, "onCreate: MVVMApplication" );

        applicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}