package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class PopularReviewBean implements Parcelable {
    private String id;
    private String title;
    private String alt;
    private String subject_id;
    private UserBean author;
    private RatingBean rating;
    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public UserBean getAuthor() {
        return author;
    }

    public void setAuthor(UserBean author) {
        this.author = author;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.alt);
        dest.writeString(this.subject_id);
        dest.writeParcelable(this.author, flags);
        dest.writeParcelable(this.rating, flags);
        dest.writeString(this.summary);
    }

    public PopularReviewBean() {
    }

    protected PopularReviewBean(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.alt = in.readString();
        this.subject_id = in.readString();
        this.author = in.readParcelable(UserBean.class.getClassLoader());
        this.rating = in.readParcelable(RatingBean.class.getClassLoader());
        this.summary = in.readString();
    }

    public static final Parcelable.Creator<PopularReviewBean> CREATOR = new Parcelable.Creator<PopularReviewBean>() {
        @Override
        public PopularReviewBean createFromParcel(Parcel source) {
            return new PopularReviewBean(source);
        }

        @Override
        public PopularReviewBean[] newArray(int size) {
            return new PopularReviewBean[size];
        }
    };
}
