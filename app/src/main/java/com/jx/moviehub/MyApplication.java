package com.jx.moviehub;

import android.app.Application;

import com.jx.moviehub.utils.ImageLoader;

/**
 * Created by Jun on 2017/1/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.initImageLoader(this);
    }
}
