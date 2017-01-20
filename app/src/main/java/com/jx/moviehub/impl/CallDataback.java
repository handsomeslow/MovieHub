package com.jx.moviehub.impl;

/**
 * Desc
 * Created by Jun on 2017/1/20.
 */

public interface CallDataback<T> {
    void onSuccess(T data);

    void onFaild(String msg);
}
