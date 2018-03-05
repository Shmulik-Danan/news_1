package com.example.elixi.news_1.dependencyinjection;

import android.app.Application;

import com.example.elixi.news_1.MVVMApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shmulik on 15 פברואר 2018.
 */

@Module
public class ApplicationModule {
    private final MVVMApplication application;
    public ApplicationModule(MVVMApplication application) {
        this.application = application;
    }

    @Provides
    MVVMApplication provideRoomDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
