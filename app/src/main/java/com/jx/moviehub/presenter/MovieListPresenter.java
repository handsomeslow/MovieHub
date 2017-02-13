package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.service.MethodsForMovie;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View view;
    private CompositeSubscription compositeSubscription;

    public MovieListPresenter(MovieListContract.View view) {
        this.view = view;
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void searchMovie(String query) {
        MethodsForMovie.getInstance().getMovieService().searchMovie(query,0,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        view.showContent(movieList);
                    }
                });

    }

    @Override
    public void getMovieInTheaters() {
        MethodsForMovie.getInstance().getMovieService().getMovieInTheaters("上海", 0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        view.showContent(movieList);
                    }
                });
    }

    @Override
    public void getTopMovie() {
        MethodsForMovie.getInstance().getMovieService().getTopMovie(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        view.showContent(movieList);
                    }
                });
    }

    @Override
    public void getMovieComingSoon() {
        MethodsForMovie.getInstance().getMovieService().getMovieComingSoon(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        view.showContent(movieList);
                    }
                });
    }
}
