package com.jx.moviehub.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jx.dataloader.entity.CelebrityBean;
import com.jx.dataloader.entity.MovieBaseSubjects;
import com.jx.dataloader.entity.WorksBean;
import com.jx.dataloader.service.MethodsForMovie;
import com.jx.moviehub.R;
import com.jx.moviehub.fragment.MovieListFragment;
import com.jx.moviehub.utils.Content;
import com.jx.moviehub.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 徐俊 on 2017/1/24.
 */

public class CelebrityDetailActivity extends BaseActivity {

    @BindView(R.id.avatar)
    SimpleDraweeView avatar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.gener)
    TextView gener;
    @BindView(R.id.work_list)
    FrameLayout workList;
    @BindView(R.id.name_en)
    TextView nameEn;
    @BindView(R.id.born_place)
    TextView bornPlace;


    private long celebrityId;


    public static Intent getIntent(Context context, long celebrityId) {
        Intent intent = new Intent();
        intent.setClass(context, CelebrityDetailActivity.class);
        intent.putExtra(Content.EXTR_CELEBRITY_ID, celebrityId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrity_detail_layout);
        ButterKnife.bind(this);
        getData();
        getCelebrityDetailData(celebrityId);
    }

    private void initView(CelebrityBean celebrityBean) {
        ImageLoader.getInstance().displayImage(celebrityBean.getAvatars().getMedium(), avatar);
        name.setText("姓名："+celebrityBean.getName());
        nameEn.setText("英文名："+celebrityBean.getName_en());
        gener.setText("性别："+celebrityBean.getGender());
        bornPlace.setText("出生地："+celebrityBean.getBorn_place());
        List<MovieBaseSubjects> subjectses = new ArrayList<>();
        for (WorksBean worksBean : celebrityBean.getWorks()) {
            subjectses.add(worksBean.getSubject());
        }
        addMovieListFragment(subjectses);
    }

    private void getData() {
        celebrityId = getIntent().getLongExtra(Content.EXTR_CELEBRITY_ID, 0);
    }

    private void getCelebrityDetailData(long id) {
        MethodsForMovie.getInstance().getMovieService().getCelebrityDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CelebrityBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CelebrityBean celebrityBean) {
                        initView(celebrityBean);
                    }
                });
    }

    private void addMovieListFragment(List<MovieBaseSubjects> subjects) {
        MovieListFragment movieListFragment = MovieListFragment.newInstance("主要作品", subjects);
        getSupportFragmentManager().beginTransaction().add(R.id.work_list, movieListFragment).commitAllowingStateLoss();
    }

}
