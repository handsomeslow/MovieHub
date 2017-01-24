package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 徐俊 on 2017/1/24.
 */

public class CelebrityBean implements Parcelable {

    /**
     * mobile_url : https://movie.douban.com/celebrity/1054395/mobile
     * aka_en : ["Elijah Jordan Wood (本名)","Elwood, Lij and Monkey (昵称)"]
     * name : 伊利亚·伍德
     * works : [{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["喜剧","短片","音乐"],"title":"SMAPxSMAP","casts":[{"alt":null,"avatars":null,"name":"中居正广","id":null},{"alt":null,"avatars":null,"name":"木村拓哉","id":null},{"alt":null,"avatars":null,"name":"稻垣吾郎","id":null}],"collect_count":2133,"original_title":"SMAPxSMAP","subtype":"tv","directors":[],"year":"1996","images":{"small":"http://img7.doubanio.com/spic/s1634671.jpg","large":"http://img7.doubanio.com/lpic/s1634671.jpg","medium":"http://img7.doubanio.com/mpic/s1634671.jpg"},"alt":"https://movie.douban.com/subject/1763308/","id":"1763308"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.2,"stars":"50","min":0},"genres":["动画","惊悚","冒险"],"title":"花园墙外","casts":[{"alt":"https://movie.douban.com/celebrity/1354353/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1475344076.93.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1475344076.93.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1475344076.93.jpg"},"name":"科林·迪恩","id":"1354353"},{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1044729/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/56083.jpg","large":"http://img7.doubanio.com/img/celebrity/large/56083.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/56083.jpg"},"name":"梅兰妮·林斯基","id":"1044729"}],"collect_count":4341,"original_title":"Over the Garden Wall","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1352267/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","large":"http://img3.doubanio.com/img/celebrity/large/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/c4A2hFhLBxUcel_avatar_uploaded1444453249.48.jpg"},"name":"帕特里克·麦克海尔","id":"1352267"}],"year":"2014","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2212480699.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2212480699.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2212480699.jpg"},"alt":"https://movie.douban.com/subject/25941842/","id":"25941842"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["剧情","动作","奇幻"],"title":"指环王3：王者无敌","casts":[{"alt":"https://movie.douban.com/celebrity/1054520/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/29922.jpg","large":"http://img7.doubanio.com/img/celebrity/large/29922.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/29922.jpg"},"name":"维果·莫腾森","id":"1054520"},{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1031818/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/11727.jpg","large":"http://img3.doubanio.com/img/celebrity/large/11727.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/11727.jpg"},"name":"西恩·奥斯汀","id":"1031818"}],"collect_count":352265,"original_title":"The Lord of the Rings: The Return of the King","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1040524/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/40835.jpg","large":"http://img7.doubanio.com/img/celebrity/large/40835.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/40835.jpg"},"name":"彼得·杰克逊","id":"1040524"}],"year":"2003","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p1910825503.jpg","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p1910825503.jpg","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p1910825503.jpg"},"alt":"https://movie.douban.com/subject/1291552/","id":"1291552"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":9,"stars":"45","min":0},"genres":["喜剧","爱情"],"title":"欢乐一家亲 第一季","casts":[{"alt":"https://movie.douban.com/celebrity/1031847/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1396501988.66.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1396501988.66.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1396501988.66.jpg"},"name":"凯尔希·格兰莫","id":"1031847"},{"alt":"https://movie.douban.com/celebrity/1000062/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/38076.jpg","large":"http://img3.doubanio.com/img/celebrity/large/38076.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/38076.jpg"},"name":"简·丽芙丝","id":"1000062"},{"alt":"https://movie.douban.com/celebrity/1000151/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/21378.jpg","large":"http://img3.doubanio.com/img/celebrity/large/21378.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/21378.jpg"},"name":"大卫·海德·皮尔斯","id":"1000151"}],"collect_count":1166,"original_title":"Frasier","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1000586/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"David Angell","id":"1000586"},{"alt":null,"avatars":null,"name":"Peter Casey","id":null},{"alt":null,"avatars":null,"name":"David Lee","id":null}],"year":"1993","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2212098341.jpg","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2212098341.jpg","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2212098341.jpg"},"alt":"https://movie.douban.com/subject/1438242/","id":"1438242"}},{"roles":["演员"],"subject":{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["剧情","喜剧","动画"],"title":"乡巴佬希尔一家的幸福生活 第一季","casts":[{"alt":"https://movie.douban.com/celebrity/1027847/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1430583698.71.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1430583698.71.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1430583698.71.jpg"},"name":"迈克·乔吉","id":"1027847"},{"alt":"https://movie.douban.com/celebrity/1004668/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/19880.jpg","large":"http://img7.doubanio.com/img/celebrity/large/19880.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/19880.jpg"},"name":"凯茜·纳基麦","id":"1004668"},{"alt":"https://movie.douban.com/celebrity/1143044/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/21887.jpg","large":"http://img3.doubanio.com/img/celebrity/large/21887.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/21887.jpg"},"name":"帕梅拉·阿德龙","id":"1143044"}],"collect_count":1470,"original_title":"King of the Hill","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1037975/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"韦斯利·阿彻","id":"1037975"}],"year":"1997","images":{"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2155829692.jpg","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2155829692.jpg","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2155829692.jpg"},"alt":"https://movie.douban.com/subject/2150064/","id":"2150064"}}]
     * gender : 男
     * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"}
     * id : 1054395
     * aka : ["伊莱贾·伍德"]
     * name_en : Elijah Wood
     * born_place : 美国,爱荷华州,锡达拉皮兹
     * alt : https://movie.douban.com/celebrity/1054395/
     */

    private String mobile_url;
    private String name;
    private String gender;
    private ImagesBean avatars;
    private String id;
    private String name_en;
    private String born_place;
    private String alt;
    private List<String> aka_en;
    private List<WorksBean> works;
    private List<String> aka;

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ImagesBean getAvatars() {
        return avatars;
    }

    public void setAvatars(ImagesBean avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getBorn_place() {
        return born_place;
    }

    public void setBorn_place(String born_place) {
        this.born_place = born_place;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<String> getAka_en() {
        return aka_en;
    }

    public void setAka_en(List<String> aka_en) {
        this.aka_en = aka_en;
    }

    public List<WorksBean> getWorks() {
        return works;
    }

    public void setWorks(List<WorksBean> works) {
        this.works = works;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mobile_url);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeParcelable(this.avatars, flags);
        dest.writeString(this.id);
        dest.writeString(this.name_en);
        dest.writeString(this.born_place);
        dest.writeString(this.alt);
        dest.writeStringList(this.aka_en);
        dest.writeTypedList(this.works);
        dest.writeStringList(this.aka);
    }

    public CelebrityBean() {
    }

    protected CelebrityBean(Parcel in) {
        this.mobile_url = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.avatars = in.readParcelable(ImagesBean.class.getClassLoader());
        this.id = in.readString();
        this.name_en = in.readString();
        this.born_place = in.readString();
        this.alt = in.readString();
        this.aka_en = in.createStringArrayList();
        this.works = in.createTypedArrayList(WorksBean.CREATOR);
        this.aka = in.createStringArrayList();
    }

    public static final Parcelable.Creator<CelebrityBean> CREATOR = new Parcelable.Creator<CelebrityBean>() {
        @Override
        public CelebrityBean createFromParcel(Parcel source) {
            return new CelebrityBean(source);
        }

        @Override
        public CelebrityBean[] newArray(int size) {
            return new CelebrityBean[size];
        }
    };
}
