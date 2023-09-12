package com.example.daggerdemo;

import com.example.daggerdemo.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("products")
    Call<ProductResponse> getPosts();
}
