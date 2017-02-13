package com.jx.moviehub.presenter;

import com.jx.dataloader.entity.CelebrityBean;
import com.jx.dataloader.service.MethodsForMovie;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public class CelebrityDataPresenter implements CelebrityDataContract.Presenter {
    private CelebrityDataContract.View view;

    public CelebrityDataPresenter(CelebrityDataContract.View view) {
        this.view = view;
    }

    @Override
    public void getCelebrityDetail(long id) {
        MethodsForMovie.getInstance().getMovieService().getCelebrityDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<CelebrityBean>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(CelebrityBean celebrityBean) {
                    view.loadCelebritySuccess(celebrityBean);
                }
            });
    }
}
