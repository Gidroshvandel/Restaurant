package com.mycompany.restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mycompany.restaurant.model.SelectDishModel;
import com.mycompany.restaurant.service.MenuService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    public static void start(Context parentContext) {
        Intent intent = new Intent(parentContext, CategoryActivity.class);
        parentContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.app_name));

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        RelativeLayout category_garnish = findViewById(R.id.category_garnish);
        category_garnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService.getInstance().create(MenuService.class).getDishModel().enqueue(new Callback<ArrayList<SelectDishModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<SelectDishModel>> call, Response<ArrayList<SelectDishModel>> response) {
                        ArrayList<SelectDishModel> selectDishModels = response.body();
                        SelectDishActivity.start(
                                CategoryActivity.this,
                                selectDishModels);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<SelectDishModel>> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "ERROR", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });
        RelativeLayout category_soup = findViewById(R.id.category_soup);
        category_soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<SelectDishModel> selectDishModels = new ArrayList<>();
                selectDishModels.add(new SelectDishModel(R.drawable.soup, "суп1", 100, 180));
                selectDishModels.add(new SelectDishModel(R.drawable.soup2, "суп2", 100, 180));
                selectDishModels.add(new SelectDishModel(R.drawable.soup3, "суп3", 100, 180));
                selectDishModels.add(new SelectDishModel(R.drawable.soup4, "суп14", 100, 180));
                SelectDishActivity.start(
                        CategoryActivity.this,
                        selectDishModels);
            }
        });
        RelativeLayout category_meat = findViewById(R.id.category_meat);
        category_meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDishActivity.start(
                        CategoryActivity.this,
                        null);
            }
        });
        RelativeLayout category_dessert = findViewById(R.id.category_dessert);
        category_dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDishActivity.start(
                        CategoryActivity.this,
                        null);
            }
        });
        RelativeLayout category_drinkables = findViewById(R.id.category_drinkables);
        category_drinkables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDishActivity.start(
                        CategoryActivity.this,
                        null);
            }
        });
        RelativeLayout category_salad = findViewById(R.id.category_salad);
        category_salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        RelativeLayout category_sauce = findViewById(R.id.category_sauce);
        category_sauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDishActivity.start(
                        CategoryActivity.this,
                        null);
            }
        });
        RelativeLayout category_snack = findViewById(R.id.category_snack);
        category_snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDishActivity.start(
                        CategoryActivity.this,
                        null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cart:
                showCart();
                return true;
            case android.R.id.home:
                finish();
                return super.onOptionsItemSelected(item);
            default:
                return true;
        }
    }

    private void showCart(){
        CartActivity.start(this);
    }



}
