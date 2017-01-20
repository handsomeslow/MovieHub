package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.moviehub.R;
import com.jx.moviehub.adapter.CastsInfoApapter;
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.utils.ImageLoader;
import com.jx.moviehub.widget.NormalTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc
 * Created by Jun on 2017/1/20.
 */

public class MovieBaseInfoFragment extends BaseFragment {
    @BindView(R.id.director_avatar)
    SimpleDraweeView directorAvatar;
    @BindView(R.id.director_name)
    TextView directorName;
    @BindView(R.id.origin_title)
    TextView originTitle;
    @BindView(R.id.avg_rating)
    TextView avgRating;
    @BindView(R.id.genres)
    TextView genres;
    @BindView(R.id.year)
    TextView year;
    @BindView(R.id.base_info)
    LinearLayout baseInfo;
    @BindView(R.id.title_cast)
    NormalTitleView titleCast;
    @BindView(R.id.casts_info)
    RecyclerView castsInfoRecyclerView;

    CastsInfoApapter castsInfoApapter;
    MovieSubjects movieSubjects;

    public static MovieBaseInfoFragment newInstance(MovieSubjects movieSubjects) {

        Bundle args = new Bundle();
        args.putParcelable(Content.EXTR_MOVIE_SUBJECT,movieSubjects);
        MovieBaseInfoFragment fragment = new MovieBaseInfoFragment();
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        movieSubjects = getArguments().getParcelable(Content.EXTR_MOVIE_SUBJECT);

        castsInfoApapter = new CastsInfoApapter();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        castsInfoRecyclerView.setLayoutManager(linearLayoutManager);
        castsInfoRecyclerView.setAdapter(castsInfoApapter);
        initView(movieSubjects);
    }

    private void initView(MovieSubjects movieSubjects) {
        titleCast.setTitle("主演：");
        ImageLoader.getInstance().displayImage(movieSubjects.getDirectors().get(0).getAvatars().getMedium(), directorAvatar);
        directorName.setText(movieSubjects.getDirectors().get(0).getName());

        originTitle.setText("原名："+movieSubjects.getOriginal_title());
        avgRating.setText("评分："+movieSubjects.getRating().getAverage());
        genres.setText("类型："+movieSubjects.getGenresStr());
        year.setText("年份："+movieSubjects.getYear());

        castsInfoApapter.addAll(movieSubjects.getCasts());
    }

}
