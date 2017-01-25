package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.R;
import com.jx.moviehub.adapter.MultiTypeListAdapter;
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.widget.NormalTitleView;

import java.util.ArrayList;
import java.util.List;

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


    List<MovieBaseSubjects> subjectsList;
    String title;

    public static MovieListFragment newInstance() {

        Bundle args = new Bundle();

        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static MovieListFragment newInstance(String title,List<MovieBaseSubjects> subjects) {

        Bundle args = new Bundle();
        args.putString(Content.EXTR_MOVIE_LIST_TITLE,title);
        args.putParcelableArrayList(Content.EXTR_MOVIE_LIST,new ArrayList<Parcelable>(subjects));
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_list, container, false);
        ButterKnife.bind(this, rootView);
        getData();
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
        listAdapter.addAll(subjectsList);
        listView.setAdapter(listAdapter);
        listView.setFocusable(true);

        listTitle.setTitle(title);
    }

    private void getData(){
        title = getArguments().getString(Content.EXTR_MOVIE_LIST_TITLE);
        subjectsList = getArguments().getParcelableArrayList(Content.EXTR_MOVIE_LIST);
    }

    protected void initView(MovieListBean movieList) {

        listTitle.setTitle(movieList.getTitle());
    }
}
