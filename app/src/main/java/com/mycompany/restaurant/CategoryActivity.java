package com.mycompany.restaurant;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mycompany.restaurant.model.MenuModel;
import com.mycompany.restaurant.service.ApiService;
import com.mycompany.restaurant.service.DataBaseService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

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
        setTitle("Меню");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        //получение списка меню от сервера
        ApiService.getInstance().create(DataBaseService.class).getMenuModel().enqueue(new Callback<ArrayList<MenuModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MenuModel>> call, Response<ArrayList<MenuModel>> response) {
                progress.hide();
                initAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<MenuModel>> call, Throwable t) {
                progress.hide();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ошибка", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }

    private void initAdapter(ArrayList<MenuModel> menuModels){
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        CategoryAdapter adapter = new CategoryAdapter(menuModels, new CategoryAdapter.ItemActionListener() {
            @Override
            public void onItemClick(int position, MenuModel menuModel) {
                SelectDishActivity.start(CategoryActivity.this, menuModel);
            }
        });
        recyclerView.setAdapter(adapter);
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
