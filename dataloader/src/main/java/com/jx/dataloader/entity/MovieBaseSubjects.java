package com.jx.dataloader.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieBaseSubjects {
    /**
     * rating : {"max":10,"average":6.9,"stars":"35","min":0}
     * genres : ["冒险","科幻"]
     * title : 太空旅客
     * casts : [{"alt":"https://movie.douban.com/celebrity/1022616/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1358747052.41.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1358747052.41.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1358747052.41.jpg"},"name":"詹妮弗·劳伦斯","id":"1022616"},{"alt":"https://movie.douban.com/celebrity/1017967/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1408271589.94.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1408271589.94.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1408271589.94.jpg"},"name":"克里斯·普拉特","id":"1017967"},{"alt":"https://movie.douban.com/celebrity/1004566/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/21073.jpg","large":"http://img7.doubanio.com/img/celebrity/large/21073.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/21073.jpg"},"name":"麦克·辛","id":"1004566"}]
     * collect_count : 34357
     * original_title : Passengers
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1299674/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1422983107.34.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1422983107.34.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1422983107.34.jpg"},"name":"莫滕·泰杜姆","id":"1299674"}]
     * year : 2016
     * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2410576676.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2410576676.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2410576676.jpg"}
     * alt : https://movie.douban.com/subject/3434070/
     * id : 3434070
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getGenresString() {
        return  genres.toString();
    }


    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public String getCastsStr(){
        String str = new String();
        for(int i=0;i<casts.size();i++)
            str += casts.get(i).getName() + " ";
        if (str.length()>16)
            str=str.substring(0,16)+"...";
        return str;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }
}
