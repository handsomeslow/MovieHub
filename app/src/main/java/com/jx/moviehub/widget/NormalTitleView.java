package com.jx.moviehub.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jx.moviehub.R;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class NormalTitleView extends LinearLayout {
    TextView title;

    public NormalTitleView(Context context) {
        this(context,null);
    }

    public NormalTitleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NormalTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.view_normal_title,this);
        title = (TextView) findViewById(R.id.title);
    }

    public void setTitle(String titleStr){
        title.setText(titleStr);
    }

}
