package com.jx.moviehub;

import android.os.Bundle;
import android.widget.Toast;

import com.jx.dataloader.entity.MovieSubjects;
import com.jx.moviehub.activity.BaseActivity;
import com.jx.moviehub.activity.MovieDetailActivity;
import com.jx.moviehub.fragment.MovieIntruduceFragment;
import com.jx.moviehub.fragment.MovieListFragment;
import com.jx.moviehub.impl.CallDataback;

public class MainActivity extends BaseActivity {

    MovieIntruduceFragment movieIntruduceFragment;
    MovieListFragment movieListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListFragment();

        getMovieDetailData(1764796, new CallDataback<MovieSubjects>() {
            @Override
            public void onSuccess(MovieSubjects data) {
                addMovieIntruduceFragment(data);
            }

            @Override
            public void onFaild(String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addMovieIntruduceFragment(MovieSubjects data){
        if (movieIntruduceFragment==null){
            movieIntruduceFragment = MovieIntruduceFragment.newInstance(data);
            addFragment(movieIntruduceFragment,R.id.introduce);
        }
    }

    private void addListFragment(){
        if (movieListFragment==null){
            movieListFragment = MovieListFragment.newInstance();
            addFragment(movieListFragment,R.id.movie_list);
        }
    }


}
