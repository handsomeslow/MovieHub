package com.jx.moviehub.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jx.dataloader.entity.CastsBean;
import com.jx.moviehub.R;
import com.jx.moviehub.viewholder.CastViewHolder;

import java.util.List;

/**
 * Created by Jun on 2017/1/19.
 */

public class CastsInfoApapter extends BaseAdapter<CastsBean,CastViewHolder> {

    public CastsInfoApapter() {
    }

    public CastsInfoApapter(Context context, List<CastsBean> list) {
        super(context, list);
    }

    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = View.inflate(parent.getContext(), R.layout.view_cast_info,null);
        CastViewHolder viewHolder = new CastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CastViewHolder holder, final int position) {
        holder.bindView(list.get(position),position);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.onItemClickListener(context,list.get(position),position,v);
            }
        });
    }
}
