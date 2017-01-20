package com.jx.moviehub.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.jx.moviehub.R;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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
//        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
//                .memoryCache(new LruMemoryCache(100 * 1024 * 1024))
//                .threadPriority(Thread.NORM_PRIORITY - 1)
//                .diskCacheSize(50 * 1024 * 1024)
//                .diskCacheFileCount(100)
//                .tasksProcessingOrder(QueueProcessingType.FIFO)
//                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
//                        .bitmapConfig(Bitmap.Config.RGB_565)
//                        .showImageForEmptyUri(R.drawable.nullpic)
//                        .cacheInMemory(true)
//                        .cacheOnDisk(true)
//                        .build())
//                .denyCacheImageMultipleSizesInMemory()
//                .build();
//        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(configuration);
    }


    public void displayImage(String imageUrl, SimpleDraweeView view){
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(ImageRequest.fromUri(imageUrl))
                .setOldController(view.getController())
                .build();
        view.setController(controller);
    }
}
