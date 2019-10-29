package com.lisn.BannerViewPager.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import com.lisn.BannerViewPager.R;
import com.lisn.BannerViewPager.viewholder.SlideModeViewHolder;
import com.lisn.bannerview.BannerViewPager;

import com.lisn.bannerview.enums.IndicatorSlideMode;
import com.lisn.bannerview.enums.IndicatorStyle;
import com.lisn.bannerview.utils.DpUtils;


import java.util.Arrays;
import java.util.List;
/**
 * Author: LiShan
 * Time: 2019-10-25
 * Description:
 */
public class IndicatorStyleActivity extends AppCompatActivity {
    private Integer[] picID = {R.drawable.placeholder,
            R.drawable.placeholder2,
            R.drawable.placeholder3,
            R.drawable.placeholder4};
    private BannerViewPager<Integer, SlideModeViewHolder> mViewPagerSmoothSlide;
    private List<Integer> mList;

    private BannerViewPager<Integer, SlideModeViewHolder> mViewPagerNormalSlide;

    private BannerViewPager<Integer, SlideModeViewHolder> mViewPagerDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_slide_mode);
        setTitle(getString(R.string.indicator_style));
        mList = Arrays.asList(picID);
        initDashIndicator();
        initCircleNormalSlide();
        initCircleSmoothSlide();
    }

    private void initDashIndicator() {
        mViewPagerDash = findViewById(R.id.banner_view_dash);
        mViewPagerDash.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(5))
                .setScrollDuration(1000)
                .setIndicatorHeight(DpUtils.dp2px(2.5f))
                .setIndicatorStyle(IndicatorStyle.DASH)
                .setIndicatorWidth(DpUtils.dp2px(10),DpUtils.dp2px(5))
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#888888"),
                        Color.parseColor("#118EEA")).create(mList);
    }

    private void initCircleSmoothSlide() {
        mViewPagerSmoothSlide = findViewById(R.id.banner_view);
        mViewPagerSmoothSlide.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(7))
                .setScrollDuration(1000)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                .setIndicatorRadius(DpUtils.dp2px(6), DpUtils.dp2px(7))
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#935656"),
                        Color.parseColor("#CCFF4C39")).create(mList);
    }

    private void initCircleNormalSlide() {
        mViewPagerNormalSlide = findViewById(R.id.banner_view_normal_slide);
        mViewPagerNormalSlide.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(7))
                .setScrollDuration(1000)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setIndicatorWidth(DpUtils.dp2px(8))
                .setIndicatorSlideMode(IndicatorSlideMode.NORMAL)
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#888888"),
                        Color.parseColor("#118EEA")).create(mList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPagerSmoothSlide.stopLoop();
        mViewPagerNormalSlide.stopLoop();
        mViewPagerDash.stopLoop();
    }
}
