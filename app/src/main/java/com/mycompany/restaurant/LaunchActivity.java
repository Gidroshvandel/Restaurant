package com.mycompany.restaurant;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(LaunchActivity.this);
                finish();
            }
        }, 2000);
    }

}
