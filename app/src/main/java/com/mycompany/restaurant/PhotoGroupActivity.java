package com.mycompany.restaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class PhotoGroupActivity extends AppCompatActivity {

    public static final String MODE = "mode";

    public static void start(Context parentContext, int mode) {
        Intent intent = new Intent(parentContext, PhotoGroupActivity.class);
        intent.putExtra(MODE, mode);
        parentContext.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_group_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.main_menu_title_photo_reports));

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ScrollView scrollView = findViewById(R.id.scrollView);
        TextView text = findViewById(R.id.photo);
        int mode = getIntent().getIntExtra(MODE, -1);
        if(mode == -1){
            scrollView.setVisibility(View.GONE);
            text.setVisibility(View.VISIBLE);
        }else if(mode == 1){
            scrollView.setVisibility(View.VISIBLE);
            text.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
