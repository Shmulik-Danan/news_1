package com.example.elixi.news_1.dependencyinjection;


import com.example.elixi.news_1.viewmodel.MainActivityViewModel;

import dagger.Subcomponent;


@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }


    MainActivityViewModel MAIN_ACTIVITY();
}
