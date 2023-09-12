package com.example.daggerdemo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.daggerdemo.model.ProductList;
import com.example.daggerdemo.model.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private ApiService apiService;

    public Repository() {
        apiService = DaggerAppComponent.create().getApiService();
    }

    public LiveData<List<ProductList>> getPosts() {
        MutableLiveData<List<ProductList>> data = new MutableLiveData<>();

        apiService.getPosts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    data.setValue(response.body().getProducts());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });


        return data;
    }
}
