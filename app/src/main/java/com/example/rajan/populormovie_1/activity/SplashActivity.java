package com.example.rajan.populormovie_1.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rajan.populormovie_1.R;

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent movieIntent = new Intent(mContext,MainActivity.class);
                startActivity(movieIntent);
                finish();
            }
        },1500);

    }

    @Override
    public void setListeners() {

    }


}