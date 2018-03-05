package com.example.elixi.news_1.dependencyinjection;

import android.app.Application;

import com.example.elixi.news_1.MVVMApplication;
import com.example.elixi.news_1.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shmulik on 15 פברואר 2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class,RetrofitModule.class})
public interface ApplicationComponent {
 //   void inject(ListFragment listFragment);
  //  void inject(CreateFragment createFragment);
   // void inject(DetailFragment detailFragment);
 void inject(MVVMApplication mvvmApplication);
    void inject(MainActivity mainActivity);

    Application application();
}
