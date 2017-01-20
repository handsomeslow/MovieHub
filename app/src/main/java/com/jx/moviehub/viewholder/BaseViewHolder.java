package com.jx.moviehub.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Jun on 2017/1/19.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<View>();
        initView();
    }

    public View getItemView() {
        return mItemView;
    }

    public View getView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = mItemView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public abstract void initView();

    public abstract void bindView(T model, int position);

    public abstract void onItemClickListener(Context context, T model, int position, View itemView);
}
