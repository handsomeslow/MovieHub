package com.jx.moviehub;

import android.os.Bundle;
import android.widget.Toast;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.entity.MovieSubjects;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.activity.BaseActivity;
import com.jx.moviehub.fragment.MovieIntruduceFragment;
import com.jx.moviehub.fragment.MovieListFragment;
import com.jx.moviehub.impl.CallMovieDataback;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    MovieIntruduceFragment movieIntruduceFragment;
    MovieListFragment movieListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMovieInTheatersData();

        getMovieDetailData(1764796, new CallMovieDataback<MovieSubjects>() {
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

    private void addListFragment(String title,List<MovieBaseSubjects> subjects){
        if (movieListFragment==null){
            movieListFragment = MovieListFragment.newInstance(title,subjects);
            addFragment(movieListFragment,R.id.movie_list);
        }
    }

    private void getMovieInTheatersData() {
        MethodsForMovie.getInstance().getMovieService().getMovieInTheaters("上海", 0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MovieListBean movieList) {
                        addListFragment(movieList.getTitle(),movieList.getSubjects());
                    }
                });
    }


}
