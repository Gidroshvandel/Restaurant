package com.mycompany.restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mycompany.restaurant.model.MenuModel;
import com.mycompany.restaurant.model.SelectDishModel;

import java.util.ArrayList;

public class SelectDishActivity extends AppCompatActivity implements SelectDishAdapter.ItemActionListener {

    private static final String MENU_MODEL = "MENU_MODEL";

    public static void start(Context parentContext, MenuModel menuModel) {
        Intent intent = new Intent(parentContext, SelectDishActivity.class);
        intent.putExtra(MENU_MODEL, menuModel);
        parentContext.startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_dish_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.app_name));

        MenuModel menuModel = (MenuModel) getIntent().getSerializableExtra(MENU_MODEL);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        TextView textView = findViewById(R.id.text_error);

        if(menuModel.getSelectDishModel() != null){
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            SelectDishAdapter adapter = new SelectDishAdapter(menuModel.getSelectDishModel(), true, false, this);
            recyclerView.setAdapter(adapter);
        }else {
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }

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

    @Override
    public void onItemClick(int position, SelectDishModel selectDishModel) {
        Cart.selectDishModels.add(selectDishModel);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Товар добавлен в корзину!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
