package com.jx.moviehub.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jx.moviehub.fragment.MovieListFragment;

import java.util.ArrayList;

/**
 * Desc
 * Created by Jun on 2017/2/6.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    ArrayList<MovieListFragment> fragments;
    String[] titles;

    public MainPagerAdapter(FragmentManager fm, ArrayList<MovieListFragment> fragments,String[] titles){
        super(fm);
        this.fragments = fragments;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
