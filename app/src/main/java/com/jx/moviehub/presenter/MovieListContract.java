package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.MovieListBean;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class MovieListContract {
    public interface View extends BaseView<MovieListBean> {

    }

    public interface Presenter extends BasePresenter {
        void searchMovie(String query);

        void getMovieInTheaters();

        void getTopMovie();

        void getMovieComingSoon();
    }
}
