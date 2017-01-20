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
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.utils.ImageLoader;
import com.jx.moviehub.widget.NormalTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieDetailFragment extends BaseFragment {

    MovieBaseInfoFragment movieBaseInfoFragment;

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    private long movieId;

    public static MovieDetailFragment newInstance(long id) {

        Bundle args = new Bundle();
        args.putLong(Content.EXTR_MOVIE_ID, id);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArgumentsData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_layout, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initView(MovieSubjects movieSubjects) {

    }



    public void refreshFragment(){
        getMovieDetailData(movieId);
    }

    protected void getArgumentsData() {
        if (getArguments() != null) {
            if (getArguments().containsKey(Content.EXTR_MOVIE_ID)) {
                movieId = getArguments().getLong(Content.EXTR_MOVIE_ID);
            }
        }

    }

    protected void getMovieDetailData(long id) {
        MethodsForMovie.getInstance().getMovieService().getMovieDetail(id)
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
