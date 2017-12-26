package com.mycompany.restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.mycompany.restaurant.model.MenuModel;
import com.mycompany.restaurant.model.UserModel;
import com.mycompany.restaurant.service.ApiService;
import com.mycompany.restaurant.service.DataBaseService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lantiets on 26.12.2017.
 */

public class StatusActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static void start(Context parentContext) {
        Intent intent = new Intent(parentContext, StatusActivity.class);
        parentContext.startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("История заказов");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerView = findViewById(R.id.recycler_view);

        ApiService.getInstance().create(DataBaseService.class).getUserModel("55555555555").enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(ArrayList<UserModel> userModels){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusAdapter adapter = new StatusAdapter(userModels);
        recyclerView.setAdapter(adapter);
    }

}
