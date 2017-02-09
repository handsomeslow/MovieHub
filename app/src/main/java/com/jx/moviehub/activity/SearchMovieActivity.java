package com.jx.moviehub.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.jx.moviehub.R;

public class SearchMovieActivity extends AppCompatActivity {


    public static Intent newIntent(Context context){
        Intent intent = new Intent();
        intent.setClass(context,SearchMovieActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qurey_movie);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
