package com.example.testonceapplication.api;

import com.example.testonceapplication.modal.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComicsApiClient {
    public static final String BASE_URL = "https://64d0dc73ff953154bb799680.mockapi.io/api/";
    private Retrofit retrofit;

    public ComicsApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getComicsList(Callback<List<Comic>> callback){
        ComicsApi comicsApi = retrofit.create(ComicsApi.class);
        Call<List<Comic>> call = comicsApi.getComics();
        call.enqueue(callback);
    }
}
