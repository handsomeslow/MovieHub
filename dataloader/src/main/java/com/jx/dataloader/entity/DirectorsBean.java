package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jun on 2017/1/18.
 */

public class DirectorsBean implements Parcelable {
    /**
     * alt : https://movie.douban.com/celebrity/1276787/
     * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/1351678808.44.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1351678808.44.jpg"}
     * name : 申·阿克
     * id : 1276787
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

    public DirectorsBean() {
    }

    protected DirectorsBean(Parcel in) {
        this.alt = in.readString();
        this.avatars = in.readParcelable(ImagesBean.class.getClassLoader());
        this.name = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<DirectorsBean> CREATOR = new Parcelable.Creator<DirectorsBean>() {
        @Override
        public DirectorsBean createFromParcel(Parcel source) {
            return new DirectorsBean(source);
        }

        @Override
        public DirectorsBean[] newArray(int size) {
            return new DirectorsBean[size];
        }
    };
}
