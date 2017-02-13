package com.jx.moviehub.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jx.dataloader.entity.CelebrityBean;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.impl.CallMovieDataback;
import com.jx.moviehub.presenter.BaseView;
import com.jx.moviehub.presenter.CelebrityDataContract;
import com.jx.moviehub.presenter.CelebrityDataPresenter;
import com.jx.moviehub.presenter.MovieDataContract;
import com.jx.moviehub.presenter.MovieDataPresenter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jun on 2017/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements MovieDataContract.View,CelebrityDataContract.View{

    MovieDataPresenter movieDataPresenter;

    CelebrityDataPresenter celebrityDataPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieDataPresenter = new MovieDataPresenter(this);
        celebrityDataPresenter = new CelebrityDataPresenter(this);
    }

    protected void addFragment(Fragment fragment, int wrap){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(wrap,fragment).commitAllowingStateLoss();
    }

    protected Fragment findFragment(int id){
        FragmentManager fm = getSupportFragmentManager();
        return fm.findFragmentById(id);
    }


    @Override
    public void loadCelebritySuccess(CelebrityBean data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void loadMovieDetailSuccess(MovieSubjects data) {

    }

    @Override
    public void showError() {

    }

}
