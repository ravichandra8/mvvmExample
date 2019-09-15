package com.jd.mvvmexample;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitServiceBuilder.init();
    }
}
