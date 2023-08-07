package com.example.testonceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testonceapplication.adapter.ComicsAdapter;
import com.example.testonceapplication.api.ComicsApiClient;
import com.example.testonceapplication.modal.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ComicsAdapter comicsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        comicsAdapter = new ComicsAdapter();
        recyclerView.setAdapter(comicsAdapter);

        ComicsApiClient comicsApiClient = new ComicsApiClient();
        comicsApiClient.getComicsList(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                if (response.isSuccessful()){
                    List<Comic> comics = response.body();
                    comicsAdapter.setComics(comics);
                }
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {

            }
        });
    }
}