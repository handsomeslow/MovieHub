package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.presenter.MovieDataContract.Presenter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class MovieDataPresenter implements MovieDataContract.Presenter{

    private MovieDataContract.View view;

    public MovieDataPresenter(MovieDataContract.View view) {
        this.view = view;
    }

    @Override
    public void getMovieDetail(long id) {
        view.showLoading();
        MethodsForMovie.getInstance().getMovieService().getMovieDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieSubjects>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onNext(MovieSubjects subjects) {
                        view.loadMovieDetailSuccess(subjects);
                    }
                });

    }


}
