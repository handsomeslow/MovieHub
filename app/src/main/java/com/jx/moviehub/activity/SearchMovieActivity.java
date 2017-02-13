package com.jx.moviehub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.jx.moviehub.R;
import com.jx.moviehub.fragment.MovieListFragment;
import com.jx.moviehub.utils.Content;

public class SearchMovieActivity extends BaseActivity {
    String query;
    MovieListFragment movieListFragment;

    public static Intent newIntent(Context context,String query){
        Intent intent = new Intent();
        intent.setClass(context,SearchMovieActivity.class);
        intent.putExtra(Content.EXTR_MOVIE_QUERY,query);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qurey_movie);
        query = getIntent().getStringExtra(Content.EXTR_MOVIE_QUERY);
        movieListFragment = MovieListFragment.newInstance("搜索结果",3,query);
        addFragment(movieListFragment,R.id.movie_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
