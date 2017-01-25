package com.jx.moviehub.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.CastsBean;
import com.jx.moviehub.R;
import com.jx.moviehub.activity.CelebrityDetailActivity;
import com.jx.moviehub.utils.ImageLoader;

/**
 * Created by Jun on 2017/1/19.
 */

public class CastViewHolder extends BaseViewHolder<CastsBean> {

    SimpleDraweeView avatar;
    TextView name;

    public CastViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void initView() {
        avatar = (SimpleDraweeView) getView(R.id.avatar);
        name = (TextView) getView(R.id.name);
    }

    @Override
    public void bindView(CastsBean model, int position) {
        ImageLoader.getInstance().displayImage(model.getAvatars().getMedium(),avatar);
        name.setText(model.getName());
    }

    @Override
    public void onItemClickListener(Context context, CastsBean model, int position, View itemView) {
        context.startActivity(CelebrityDetailActivity.getIntent(context,Long.valueOf(model.getId())));
    }
}
