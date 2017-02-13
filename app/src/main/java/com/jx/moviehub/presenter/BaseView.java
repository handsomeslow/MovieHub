package com.jx.moviehub.presenter;


/**
 * Desc
 * Created by Jun on 2017/2/13.
 */

public interface BaseView<T> {
    void showLoading();

    void showContent(T data);

    void showError();

    void ShowNoneContent();
}
