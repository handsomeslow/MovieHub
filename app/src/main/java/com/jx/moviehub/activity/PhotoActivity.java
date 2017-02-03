package com.jx.moviehub.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.moviehub.R;
import com.jx.moviehub.utils.Content;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class PhotoActivity extends BaseActivity {


    @BindView(R.id.photo_view)
    SimpleDraweeView photoView;

    public static Intent newIntent(Context context,String imgUrl) {
        Intent intent = new Intent();
        intent.setClass(context, PhotoActivity.class);
        intent.putExtra(Content.EXTR_COVER_PHOTO_URL,imgUrl);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_layout);
        ButterKnife.bind(this);
        String coverUrl = getIntent().getStringExtra(Content.EXTR_COVER_PHOTO_URL);
        photoView.setImageURI(coverUrl);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
