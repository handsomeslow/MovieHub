package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.R;
import com.jx.moviehub.adapter.MultiTypeListAdapter;
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

public class MovieListFragment extends BaseFragment {

    MultiTypeListAdapter listAdapter;

    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.list_title)
    NormalTitleView listTitle;


    public static MovieListFragment newInstance() {

        Bundle args = new Bundle();

        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_list, container, false);
        ButterKnife.bind(this, rootView);
        getMovieData();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listAdapter = new MultiTypeListAdapter();

        listView.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        listView.setAdapter(listAdapter);
        listView.setFocusable(true);
    }


    private void getMovieData() {
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
                        initView(movieList);
                    }
                });
    }

    protected void initView(MovieListBean movieList) {
        listAdapter.addAll(movieList.getSubjects());
        listTitle.setTitle(movieList.getTitle());
    }
}
