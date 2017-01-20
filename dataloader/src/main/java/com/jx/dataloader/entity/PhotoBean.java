package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class PhotoBean implements Parcelable {
    private String id;
    private String alt;
    private String icon;
    private String image;
    private String thumb;
    private String cover;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.alt);
        dest.writeString(this.icon);
        dest.writeString(this.image);
        dest.writeString(this.thumb);
        dest.writeString(this.cover);
    }

    public PhotoBean() {
    }

    protected PhotoBean(Parcel in) {
        this.id = in.readString();
        this.alt = in.readString();
        this.icon = in.readString();
        this.image = in.readString();
        this.thumb = in.readString();
        this.cover = in.readString();
    }

    public static final Parcelable.Creator<PhotoBean> CREATOR = new Parcelable.Creator<PhotoBean>() {
        @Override
        public PhotoBean createFromParcel(Parcel source) {
            return new PhotoBean(source);
        }

        @Override
        public PhotoBean[] newArray(int size) {
            return new PhotoBean[size];
        }
    };
}
