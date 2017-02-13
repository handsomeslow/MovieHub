package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.moviehub.R;
import com.jx.moviehub.adapter.MultiTypeListAdapter;
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.widget.NormalTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieListFragment extends BaseListFragment {

    MultiTypeListAdapter listAdapter;

    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.list_title)
    NormalTitleView listTitle;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.nonecontent_view)
    ImageView nonecontentView;
    @BindView(R.id.bad_net)
    ImageView badNet;

    private List<MovieBaseSubjects> subjectsList;
    private String title;
    private int type;
    private String query;

    public static MovieListFragment newInstance(String title, int type) {

        Bundle args = new Bundle();
        args.putString(Content.EXTR_MOVIE_LIST_TITLE, title);
        args.putInt(Content.EXTR_MOVIE_LIST_YTPE, type);
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static MovieListFragment newInstance(String title, int type, String query) {

        Bundle args = new Bundle();
        args.putString(Content.EXTR_MOVIE_LIST_TITLE, title);
        args.putInt(Content.EXTR_MOVIE_LIST_YTPE, type);
        args.putString(Content.EXTR_MOVIE_QUERY, query);
        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static MovieListFragment newInstance(String title, List<MovieBaseSubjects> subjects) {

        Bundle args = new Bundle();
        args.putString(Content.EXTR_MOVIE_LIST_TITLE, title);
        args.putParcelableArrayList(Content.EXTR_MOVIE_LIST, new ArrayList<Parcelable>(subjects));
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
        listTitle.setVisibility(View.GONE);
        getMovieList();
    }

    private void initListView(List<MovieBaseSubjects> subjectsList) {
        listAdapter = new MultiTypeListAdapter();

//        listView.setLayoutManager(new LinearLayoutManager(getActivity()) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        });
        listView.setLayoutManager(new LinearLayoutManager(listView.getContext()));
        listAdapter.addAll(subjectsList);
        listView.setAdapter(listAdapter);
        listView.setFocusable(true);

        if (title!=null){
            initTitle(title);
        }
    }

    private void getData() {
        title = getArguments().getString(Content.EXTR_MOVIE_LIST_TITLE);
        subjectsList = getArguments().getParcelableArrayList(Content.EXTR_MOVIE_LIST);
        type = getArguments().getInt(Content.EXTR_MOVIE_LIST_YTPE, 1);
        query = getArguments().getString(Content.EXTR_MOVIE_QUERY);
    }

    protected void initView(MovieListBean movieList) {

        listTitle.setTitle(movieList.getTitle());
    }

    private void initTitle(String title){
        listTitle.setVisibility(View.VISIBLE);
        listTitle.setTitle(String.format("搜索“%s”结果",query));
    }

    private void getMovieList() {
        if (subjectsList != null && subjectsList.size() > 0) {
            initListView(subjectsList);
            return;
        }
        switch (type) {
            case 0:
                movieListPresenter.getMovieInTheaters();
                break;

            case 1:
                movieListPresenter.getTopMovie();
                break;

            case 2:
                movieListPresenter.getMovieComingSoon();
                break;

            case 3:
                movieListPresenter.searchMovie(query);
        }
    }

    @Override
    public void showLoading() {
        super.showLoading();
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContent(MovieListBean data) {
        super.showContent(data);
        initListView(data.getSubjects());
        loading.setVisibility(View.GONE);
    }

    @Override
    public void ShowNoneContent() {
        loading.setVisibility(View.GONE);
        nonecontentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        super.showError();
        loading.setVisibility(View.GONE);
        badNet.setVisibility(View.VISIBLE);
    }
}
