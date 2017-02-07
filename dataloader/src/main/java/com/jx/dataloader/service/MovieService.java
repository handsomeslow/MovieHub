package com.jx.dataloader.service;


import com.jx.dataloader.entity.CelebrityBean;
import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;
import com.jx.dataloader.entity.MovieSubjects;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Jun on 2017/1/18.
 */

public interface MovieService {

    /**
     * 电影详情
     * @param id
     * @return
     */
    @GET("subject/{id}")
    Observable<MovieSubjects> getMovieDetail(
            @Path("id") long id
    );


    /**
     * 获取正在热映的电影
     * @param city
     * @param start
     * @param count
     * @return
     */
    @GET("in_theaters")
    Observable<MovieListBean> getMovieInTheaters(
            @Query("city")String city,
            @Query("start")int start,
            @Query("count")int count
    );

    @GET("top250")
    Observable<MovieListBean> getTopMovie(
            @Query("start")int start,
            @Query("count")int count);

    @GET("coming_soon")
    Observable<MovieListBean> getMovieComingSoon(
            @Query("start")int start,
            @Query("count")int count
    );

    /**
     * 获取演员信息
     * @param id
     * @return
     */
    @GET("celebrity/{id}")
    Observable<CelebrityBean> getCelebrityDetail(
            @Path("id") long id
    );
}
