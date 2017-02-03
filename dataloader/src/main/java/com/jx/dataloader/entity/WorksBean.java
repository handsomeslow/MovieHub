package com.jx.dataloader.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 徐俊 on 2017/1/24.
 */

public class WorksBean implements Parcelable {
    /**
     * roles : ["演员"]
     * subject : {"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["喜剧","短片","音乐"],"title":"SMAPxSMAP","casts":[{"alt":null,"avatars":null,"name":"中居正广","id":null},{"alt":null,"avatars":null,"name":"木村拓哉","id":null},{"alt":null,"avatars":null,"name":"稻垣吾郎","id":null}],"collect_count":2133,"original_title":"SMAPxSMAP","subtype":"tv","directors":[],"year":"1996","images":{"small":"http://img7.doubanio.com/spic/s1634671.jpg","large":"http://img7.doubanio.com/lpic/s1634671.jpg","medium":"http://img7.doubanio.com/mpic/s1634671.jpg"},"alt":"https://movie.douban.com/subject/1763308/","id":"1763308"}
     */

    private MovieBaseSubjects subject;
    private List<String> roles;

    public MovieBaseSubjects getSubject() {
        return subject;
    }

    public void setSubject(MovieBaseSubjects subject) {
        this.subject = subject;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.subject, flags);
        dest.writeStringList(this.roles);
    }

    public WorksBean() {
    }

    protected WorksBean(Parcel in) {
        this.subject = in.readParcelable(MovieBaseSubjects.class.getClassLoader());
        this.roles = in.createStringArrayList();
    }

    public static final Parcelable.Creator<WorksBean> CREATOR = new Parcelable.Creator<WorksBean>() {
        @Override
        public WorksBean createFromParcel(Parcel source) {
            return new WorksBean(source);
        }

        @Override
        public WorksBean[] newArray(int size) {
            return new WorksBean[size];
        }
    };
}
