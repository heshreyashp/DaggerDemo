package com.example.daggerdemo;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("products")
    Call<ProductResponse> getPosts();
}
