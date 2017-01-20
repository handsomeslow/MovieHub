package com.jx.dataloader.service;

import com.jx.dataloader.ServiceContent;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Jun on 2017/1/18.
 */

public class MethodsForMovie {

    Retrofit retrofit;

    public MovieService getMovieService() {
        return movieService;
    }

    MovieService movieService;
    public CompositeSubscription subscriptions;


    private static MethodsForMovie ourInstance = new MethodsForMovie();
    public static MethodsForMovie getInstance() {
        return ourInstance;
    }

    private MethodsForMovie() {
        retrofit  = new Retrofit.Builder()
                .baseUrl(ServiceContent.hostUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        movieService = retrofit.create(MovieService.class);
        subscriptions = new CompositeSubscription();
    }

}
