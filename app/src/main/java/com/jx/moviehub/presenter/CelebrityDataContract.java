package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.CelebrityBean;
import com.jx.dataloader.entity.MovieSubjects;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class CelebrityDataContract {
    public interface View {
        void showLoading();

        void loadCelebritySuccess(CelebrityBean data);

        void showError();
    }

    public interface Presenter extends BasePresenter {
        void getCelebrityDetail(long id);
    }
}
