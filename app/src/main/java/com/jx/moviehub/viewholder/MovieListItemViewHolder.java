package com.jx.moviehub.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.moviehub.R;
import com.jx.moviehub.activity.MovieDetailActivity;
import com.jx.moviehub.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc
 * Created by Jun on 2017/1/19.
 */

public class MovieListItemViewHolder extends BaseViewHolder<MovieBaseSubjects> {
    public static final int LAYOUT_LIST_ITEM = R.layout.view_movie_item;

    @BindView(R.id.movie_pic)
    SimpleDraweeView moviePic;
    @BindView(R.id.movie_year)
    TextView movieYear;
    @BindView(R.id.movie_genres)
    TextView movieGenres;
    @BindView(R.id.movie_title)
    TextView movieTitle;
    @BindView(R.id.movie_directors)
    TextView movieDirectors;
    @BindView(R.id.movie_casts)
    TextView movieCasts;
    @BindView(R.id.movie_rating)
    TextView movieRating;
    @BindView(R.id.movie_rating_bar)
    RatingBar movieRatingBar;

    public MovieListItemViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(MovieBaseSubjects model, int position) {
        movieTitle.setText(model.getTitle());
        movieYear.setText(model.getYear());
        movieRating.setText("评分：" + model.getRating().getAverage());
        movieRatingBar.setRating((float) model.getRating().getAverage()/2);
        movieGenres.setText(" / "+model.getGenresString()
                .substring(1,model.getGenresString().length()-1));
        if (model.getDirectors().size()>0)
            movieDirectors.setText("导演：" + model.getDirectors().get(0).getName());
        movieCasts.setText("演员：" + model.getCastsStr());
        ImageLoader.getInstance().displayImage(model.getImages().getMedium(),moviePic);
    }

    @Override
    public void onItemClickListener(Context context, MovieBaseSubjects model, int position, View itemView) {
        context.startActivity(MovieDetailActivity.getIntent(context,Long.valueOf(model.getId())));
    }
}
