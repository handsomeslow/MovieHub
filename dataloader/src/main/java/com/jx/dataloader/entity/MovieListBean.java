package com.jx.dataloader.entity;

import java.util.List;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieListBean {


    /**
     * count : 20
     * start : 0
     * total : 26
     * subjects : [{"rating":{"max":10,"average":6.9,"stars":"35","min":0},"genres":["冒险","科幻"],"title":"太空旅客","casts":[{"alt":"https://movie.douban.com/celebrity/1022616/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1358747052.41.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1358747052.41.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1358747052.41.jpg"},"name":"詹妮弗·劳伦斯","id":"1022616"},{"alt":"https://movie.douban.com/celebrity/1017967/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1408271589.94.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1408271589.94.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1408271589.94.jpg"},"name":"克里斯·普拉特","id":"1017967"},{"alt":"https://movie.douban.com/celebrity/1004566/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/21073.jpg","large":"http://img7.doubanio.com/img/celebrity/large/21073.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/21073.jpg"},"name":"麦克·辛","id":"1004566"}],"collect_count":34357,"original_title":"Passengers","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1299674/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1422983107.34.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1422983107.34.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1422983107.34.jpg"},"name":"莫滕·泰杜姆","id":"1299674"}],"year":"2016","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2410576676.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2410576676.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2410576676.jpg"},"alt":"https://movie.douban.com/subject/3434070/","id":"3434070"}]
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<MovieBaseSubjects> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieBaseSubjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieBaseSubjects> subjects) {
        this.subjects = subjects;
    }

}
