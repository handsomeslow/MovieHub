package com.jx.moviehub.utils;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;


/**
 * Created by Jun on 2017/1/18.
 */

public class ImageLoader {
    private static final ImageLoader imageLoader = new ImageLoader();
    public static ImageLoader getInstance() {
        return imageLoader;
    }
    public static void initImageLoader(Context context) {
        Fresco.initialize(context);
    }


    public void displayImage(String imageUrl, SimpleDraweeView view){
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(imageUrl))
                .setOldController(view.getController())
                .build();
        view.setController(controller);
    }
}
