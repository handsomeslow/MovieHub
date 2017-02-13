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


    private void showContent(MovieListBean movieListBean){
        if (movieListBean != null && movieListBean.getCount() >0 && movieListBean.getSubjects().size() >0){
            view.showContent(movieListBean);
        } else {
            view.ShowNoneContent();
        }
    }

    @Override
    public void searchMovie(String query) {
        view.showLoading();
        MethodsForMovie.getInstance().getMovieService().searchMovie(query,0,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        showContent(movieList);
                    }
                });

    }

    @Override
    public void getMovieInTheaters() {
        view.showLoading();
        MethodsForMovie.getInstance().getMovieService().getMovieInTheaters("上海", 0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        showContent(movieList);
                    }
                });
    }

    @Override
    public void getTopMovie() {
        view.showLoading();
        MethodsForMovie.getInstance().getMovieService().getTopMovie(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        showContent(movieList);
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
                        view.showError();
                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        showContent(movieList);
                    }
                });
    }
}
