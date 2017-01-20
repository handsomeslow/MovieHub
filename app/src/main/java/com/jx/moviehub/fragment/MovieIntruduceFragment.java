package com.jx.moviehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.moviehub.R;
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc
 * Created by Jun on 2017/1/20.
 */

public class MovieIntruduceFragment extends BaseFragment {
    @BindView(R.id.cover_pic)
    SimpleDraweeView coverPic;
    @BindView(R.id.introduce)
    TextView introduce;

    MovieSubjects movieSubjects;

    public static MovieIntruduceFragment newInstance(MovieSubjects movieSubjects) {

        Bundle args = new Bundle();
        args.putParcelable(Content.EXTR_MOVIE_SUBJECT,movieSubjects);
        MovieIntruduceFragment fragment = new MovieIntruduceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intruduce_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieSubjects = getArguments().getParcelable(Content.EXTR_MOVIE_SUBJECT);
        initView(movieSubjects);
    }

    private void initView(MovieSubjects movieSubjects){
        ImageLoader.getInstance().displayImage(movieSubjects.getImages().getLarge(), coverPic);
        introduce.setText(movieSubjects.getSummary());
    }
}
