package com.jx.moviehub.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.impl.CallMovieDataback;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jun on 2017/1/18.
 */

public class BaseActivity extends AppCompatActivity {

    protected void addFragment(Fragment fragment,int wrap){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(wrap,fragment).commitAllowingStateLoss();
    }

    protected Fragment findFragment(int id){
        FragmentManager fm = getSupportFragmentManager();
        return fm.findFragmentById(id);
    }

    protected void getMovieDetailData(long id, final CallMovieDataback callDataback) {
        MethodsForMovie.getInstance().getMovieService().getMovieDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieSubjects>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callDataback!=null){
                            callDataback.onFaild(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(MovieSubjects movieSubjects) {
                        if (callDataback!=null){
                            callDataback.onSuccess(movieSubjects);
                        }
                    }
                });
    }

}
