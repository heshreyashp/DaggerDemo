package com.example.daggerdemo;
import com.example.daggerdemo.screenui.MainActivity;
import com.example.daggerdemo.viiewmodel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, ViewModelModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    MainActivityViewModel getYourViewModel();
    ApiService getApiService();
}

