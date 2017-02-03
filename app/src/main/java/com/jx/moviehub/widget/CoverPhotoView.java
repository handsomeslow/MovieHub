package com.jx.moviehub.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Desc
 * Created by Jun on 2017/2/3.
 */

public class CoverPhotoView extends SimpleDraweeView {

    public CoverPhotoView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public CoverPhotoView(Context context) {
        super(context);
    }

    public CoverPhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CoverPhotoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CoverPhotoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        Path path = new Path();
        path.moveTo(0,getHeight());
        path.lineTo(getWidth(),getHeight()-getHeight()/4);
        path.lineTo(getWidth(),getHeight());
        path.close();
        canvas.drawPath(path, paint);
    }
}
