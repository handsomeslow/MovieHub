package com.jx.moviehub.viewholder;

import android.view.View;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public interface ListTypeFactory {
    int type(Object model);
    BaseViewHolder createViewHolder(int type, View itemView);
}
