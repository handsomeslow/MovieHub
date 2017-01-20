package com.jx.moviehub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jun on 2017/1/19.
 */

public abstract class BaseAdapter<E,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<E> list;
    protected Context context;

    public BaseAdapter() {
        list = new ArrayList<>();
    }

    public BaseAdapter(Context context, List<E> list) {
        this.context = context;
        this.list = list;
        if (this.list==null){
            this.list = new ArrayList<>();
        }
    }

    @Override
    public int getItemCount() {
        if (list!=null && list.size()>0){
            return list.size();
        }
        return 0;
    }

    public List<E> getList() {
        return list;
    }

    public E getItem(int position){
        if (list!=null && list.size()>0){
            return list.get(position);
        }
        return null;
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addAll(List<E> list) {
        if (null == this.list || null == list || list.size() == 0) {
            return;
        }

        this.list.addAll(list);
        notifyDataSetChanged();
    }

}
