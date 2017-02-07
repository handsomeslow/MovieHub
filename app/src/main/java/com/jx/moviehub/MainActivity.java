package com.jx.moviehub;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.activity.BaseActivity;
import com.jx.moviehub.adapter.MainPagerAdapter;
import com.jx.moviehub.fragment.MovieIntruduceFragment;
import com.jx.moviehub.fragment.MovieListFragment;
import com.jx.moviehub.impl.CallMovieDataback;
import com.jx.moviehub.widget.CoordinatorTabLayout;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    private ArrayList<MovieListFragment> movieListFragments;
    private CoordinatorTabLayout coordinatorTabLayout;
    private ViewPager viewPager;
    private MainPagerAdapter pagerAdapter;

    private int[] imageArray,colorArray;
    private final String[] titles = {"正在热映","Top","即将上映"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_layout);
        imageArray = new int[]{R.drawable.bg_android,
                R.drawable.bg_ios,
                R.drawable.bg_other};

        colorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_green_light};

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);

        addListFragments();

        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),movieListFragments,titles);
        viewPager.setAdapter(pagerAdapter);

        coordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.tablayout);
        coordinatorTabLayout.setImageArray(imageArray,colorArray)
                .setUpWithViewPager(viewPager);
    }

    private void addListFragments(){
        movieListFragments = new ArrayList<>();
        for (int i =0;i<3;i++){
            movieListFragments.add(MovieListFragment.newInstance(titles[i],i));
        }
    }

}
