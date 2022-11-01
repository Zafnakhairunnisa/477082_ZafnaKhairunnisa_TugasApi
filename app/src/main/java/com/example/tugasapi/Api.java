package com.example.tugasapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("users")
    Call<Users> getUsers();

    @GET("users")
    Call<List<Users>> getDataUsers(@Query("size") int number);

}
