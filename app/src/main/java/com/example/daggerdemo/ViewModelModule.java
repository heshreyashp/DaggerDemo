package com.example.daggerdemo;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Provides
    MainActivityViewModel provideYourViewModel() {
        return new MainActivityViewModel();
    }
}