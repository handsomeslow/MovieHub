package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.R;
import com.jx.moviehub.adapter.CastsInfoApapter;
import com.jx.moviehub.utils.ImageLoader;
import com.jx.moviehub.widget.NormalTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jun on 2017/1/18.
 */

public class DailyPushMovieFragment extends BaseFragment {


    CastsInfoApapter castsInfoApapter;

    public static DailyPushMovieFragment newInstance() {

        Bundle args = new Bundle();

        DailyPushMovieFragment fragment = new DailyPushMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_detail_layout, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initView(MovieSubjects movieSubjects) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getData();

    }

    private void getData() {
        MethodsForMovie.getInstance().getMovieService().getMovieDetail(1764796)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieSubjects>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieSubjects movieSubjects) {
                        initView(movieSubjects);
                    }
                });
    }
}
