package com.jx.moviehub.viewholder;

import android.view.View;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.MovieListBean;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class TypeFactoryForMovieList implements ListTypeFactory {

    @Override
    public int type(Object model) {
        if (model instanceof MovieBaseSubjects){
            return MovieListItemViewHolder.LAYOUT_LIST_ITEM;
        }
        return MovieListItemViewHolder.LAYOUT_LIST_ITEM;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type){
            case MovieListItemViewHolder.LAYOUT_LIST_ITEM:
                return new MovieListItemViewHolder(itemView);
        }
        return null;
    }
}
