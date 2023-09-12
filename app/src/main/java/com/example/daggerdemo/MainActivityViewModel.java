package com.example.daggerdemo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainActivityViewModel extends ViewModel {


    private Repository repository;
    private LiveData<List<ProductList>> posts;

    public MainActivityViewModel() {
        repository = new Repository();
        posts = repository.getPosts();
    }

    public LiveData<List<ProductList>> getPosts() {
        return posts;
    }
}

