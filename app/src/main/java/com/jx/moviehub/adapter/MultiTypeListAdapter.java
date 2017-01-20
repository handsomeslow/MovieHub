package com.jx.moviehub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.moviehub.viewholder.BaseViewHolder;
import com.jx.moviehub.viewholder.ListTypeFactory;
import com.jx.moviehub.viewholder.TypeFactoryForMovieList;

import java.util.List;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MultiTypeListAdapter extends BaseAdapter<MovieBaseSubjects,BaseViewHolder> {

    ListTypeFactory listTypeFactory;

    public MultiTypeListAdapter() {
        this.listTypeFactory = new TypeFactoryForMovieList();
    }

    public MultiTypeListAdapter(List<MovieBaseSubjects> list) {
        this.list = list;
        this.listTypeFactory = new TypeFactoryForMovieList();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(viewType,parent,false);
        return listTypeFactory.createViewHolder(viewType,itemView);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        holder.bindView(list.get(position),position);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.onItemClickListener(context,list.get(position),position,view);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return listTypeFactory.type(list.get(position));
    }
}
