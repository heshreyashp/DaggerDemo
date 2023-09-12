package com.example.daggerdemo;

import com.example.daggerdemo.viiewmodel.MainActivityViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Provides
    MainActivityViewModel provideYourViewModel() {
        return new MainActivityViewModel();
    }
}