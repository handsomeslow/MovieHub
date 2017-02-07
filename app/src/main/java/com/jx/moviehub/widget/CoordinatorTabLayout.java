package com.jx.moviehub.widget;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jx.moviehub.R;

/**
 * Desc
 * Created by Jun on 2017/2/6.
 */

public class CoordinatorTabLayout extends CoordinatorLayout {
    private Context context;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private TabLayout tabLayout;
    private ImageView imageView;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    public CoordinatorTabLayout(Context context) {
        super(context);
        this.context = context;
    }

    public CoordinatorTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public CoordinatorTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView(){
        LayoutInflater.from(context).inflate(R.layout.view_coordinatortab_layout,this);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbarlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((AppCompatActivity)context).setSupportActionBar(toolbar);
        actionBar = ((AppCompatActivity) context).getSupportActionBar();
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public CoordinatorTabLayout setTitle(String title){
        if (actionBar!=null){
            actionBar.setTitle(title);
        }
        return this;
    }

    private void setUpTabLayout(final int[] imageArray,final int[] colorArray){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                imageView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_dismiss));
                imageView.setImageResource(imageArray[tab.getPosition()]);
                if (colorArray!=null){
                    collapsingToolbarLayout.setContentScrimColor(
                            ContextCompat.getColor(context,colorArray[tab.getPosition()])
                    );
                }
                imageView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.anim_show));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public CoordinatorTabLayout setImageArray(int[] imageArray){
        if (imageArray!=null){
            imageView.setImageResource(imageArray[0]);
            setUpTabLayout(imageArray,null);
        }
        return this;
    }

    public CoordinatorTabLayout setImageArray(int[] imageArray, int[] colorArray){
        if (imageArray!=null){
            imageView.setImageResource(imageArray[0]);
            setUpTabLayout(imageArray,colorArray);
        }
        return this;
    }

    public CoordinatorTabLayout setUpWithViewPager(ViewPager viewPager){
        tabLayout.setupWithViewPager(viewPager);
        return this;
    }

}
