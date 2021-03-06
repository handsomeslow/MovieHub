package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jun on 2017/1/18.
 */

public class RatingBean implements Parcelable {
    /**
     * max : 10
     * average : 7.4
     * stars : 40
     * min : 0
     */

    private int max;
    private double average;
    private String stars;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.max);
        dest.writeDouble(this.average);
        dest.writeString(this.stars);
        dest.writeInt(this.min);
    }

    public RatingBean() {
    }

    protected RatingBean(Parcel in) {
        this.max = in.readInt();
        this.average = in.readDouble();
        this.stars = in.readString();
        this.min = in.readInt();
    }

    public static final Parcelable.Creator<RatingBean> CREATOR = new Parcelable.Creator<RatingBean>() {
        @Override
        public RatingBean createFromParcel(Parcel source) {
            return new RatingBean(source);
        }

        @Override
        public RatingBean[] newArray(int size) {
            return new RatingBean[size];
        }
    };
}
