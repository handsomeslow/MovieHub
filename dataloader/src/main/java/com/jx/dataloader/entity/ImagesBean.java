package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jun on 2017/1/18.
 */

public class ImagesBean implements Parcelable {
    /**
     * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.jpg
     * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.jpg
     * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p494268647.jpg
     */

    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.large);
        dest.writeString(this.medium);
    }

    public ImagesBean() {
    }

    protected ImagesBean(Parcel in) {
        this.small = in.readString();
        this.large = in.readString();
        this.medium = in.readString();
    }

    public static final Parcelable.Creator<ImagesBean> CREATOR = new Parcelable.Creator<ImagesBean>() {
        @Override
        public ImagesBean createFromParcel(Parcel source) {
            return new ImagesBean(source);
        }

        @Override
        public ImagesBean[] newArray(int size) {
            return new ImagesBean[size];
        }
    };
}
