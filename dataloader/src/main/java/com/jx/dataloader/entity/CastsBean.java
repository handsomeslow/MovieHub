package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jun on 2017/1/18.
 */

public class CastsBean implements Parcelable {
    /**
     * alt : https://movie.douban.com/celebrity/1054395/
     * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/51597.jpg","large":"http://img3.doubanio.com/img/celebrity/large/51597.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/51597.jpg"}
     * name : 伊利亚·伍德
     * id : 1054395
     */

    private String alt;
    private ImagesBean avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public ImagesBean getAvatars() {
        return avatars;
    }

    public void setAvatars(ImagesBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.alt);
        dest.writeParcelable(this.avatars, flags);
        dest.writeString(this.name);
        dest.writeString(this.id);
    }

    public CastsBean() {
    }

    protected CastsBean(Parcel in) {
        this.alt = in.readString();
        this.avatars = in.readParcelable(ImagesBean.class.getClassLoader());
        this.name = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<CastsBean> CREATOR = new Parcelable.Creator<CastsBean>() {
        @Override
        public CastsBean createFromParcel(Parcel source) {
            return new CastsBean(source);
        }

        @Override
        public CastsBean[] newArray(int size) {
            return new CastsBean[size];
        }
    };
}
