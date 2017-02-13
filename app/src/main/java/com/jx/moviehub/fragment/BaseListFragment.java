package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.jx.dataloader.entity.MovieListBean;
import com.jx.moviehub.presenter.MovieListContract;
import com.jx.moviehub.presenter.MovieListPresenter;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public abstract class BaseListFragment extends Fragment implements MovieListContract.View {
    MovieListPresenter movieListPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieListPresenter = new MovieListPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent(MovieListBean data) {

    }

    @Override
    public void showError() {

    }

}
