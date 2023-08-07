package com.example.testonceapplication.api;

import com.example.testonceapplication.modal.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ComicsApi {

    @GET("comics")
    Call<List<Comic>> getComics();
}
