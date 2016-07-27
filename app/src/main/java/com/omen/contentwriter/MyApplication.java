package com.omen.contentwriter;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2016/7/27.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
