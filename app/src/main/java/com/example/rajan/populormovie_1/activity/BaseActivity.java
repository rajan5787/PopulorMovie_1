package com.example.rajan.populormovie_1.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    public abstract void initView();
    public abstract void setListeners();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        initView();
        setListeners();
    }

    @Override
    protected void onStart() {

        super.onStart();
    }
}
