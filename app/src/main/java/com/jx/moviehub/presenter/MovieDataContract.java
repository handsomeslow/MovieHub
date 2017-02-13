package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieSubjects;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class MovieDataContract {
    public interface View {
        void showLoading();

        void loadMovieDetailSuccess(MovieSubjects data);

        void showError();

    }

    public interface Presenter extends BasePresenter {
        void getMovieDetail(long id);

    }
}
