package com.jx.moviehub.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.jx.dataloader.entity.MovieSubjects;
import com.jx.moviehub.R;
import com.jx.moviehub.fragment.MovieBaseInfoFragment;
import com.jx.moviehub.fragment.MovieIntruduceFragment;
import com.jx.moviehub.impl.CallMovieDataback;
import com.jx.moviehub.utils.Content;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieDetailActivity extends BaseActivity {

    private MovieIntruduceFragment movieIntruduceFragment;
    private MovieBaseInfoFragment movieBaseInfoFragment;

    private long id;

    public static Intent getIntent(Context context, long id) {
        Intent intent = new Intent();
        intent.setClass(context,MovieDetailActivity.class);
        intent.putExtra(Content.EXTR_MOVIE_ID,id);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail_layout);
        id = getIntent().getLongExtra(Content.EXTR_MOVIE_ID,0);

        getMovieDetailData(id, new CallMovieDataback<MovieSubjects>() {
            @Override
            public void onSuccess(MovieSubjects data) {
                addBaseInfoFragment(data);
                addMovieIntruduceFragment(data);
            }

            @Override
            public void onFaild(String msg) {
                Toast.makeText(MovieDetailActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addMovieIntruduceFragment(MovieSubjects data){
        if (movieIntruduceFragment==null){
            movieIntruduceFragment = MovieIntruduceFragment.newInstance(data);
            addFragment(movieIntruduceFragment,R.id.introduce);
        }
    }


    private void addBaseInfoFragment(MovieSubjects movieSubjects){
        if (movieBaseInfoFragment==null){
            movieBaseInfoFragment = MovieBaseInfoFragment.newInstance(movieSubjects);
            addFragment(movieBaseInfoFragment,R.id.base_info);
        }
    }


}
