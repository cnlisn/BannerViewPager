package com.lisn.BannerViewPager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lisn.BannerViewPager.R;
import com.lisn.BannerViewPager.viewholder.SlideModeViewHolder;
import com.lisn.bannerview.BannerViewPager;
import com.lisn.bannerview.indicator.DashIndicatorView;
import com.lisn.bannerview.utils.DpUtils;


import java.util.Arrays;
import java.util.List;

/**
 * Created by LiShan on 2019-10-25.
 * Description:
 */
public class CustomIndicatorActivity extends AppCompatActivity {
    private Integer[] picID = {R.drawable.placeholder,
            R.drawable.placeholder2,
            R.drawable.placeholder3,
            R.drawable.placeholder4};
    BannerViewPager<Integer, SlideModeViewHolder> viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_slide_mode);
        setTitle(getString(R.string.custom_indicator_view));
        setUpViewPager();
    }

    private void setUpViewPager() {
        viewPager = findViewById(R.id.banner_view_dash);
        List<Integer> list = Arrays.asList(picID);
        viewPager.setAutoPlay(false).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorView(setupIndicatorView(list.size()))
                .setOnPageClickListener(position -> Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show())
                .setHolderCreator(SlideModeViewHolder::new).create(list);
    }

    /**
     * 这里可以是自定义的Indicator，需要继承BaseIndicatorView或者实现IIndicator接口;
     */
    private DashIndicatorView setupIndicatorView(int pageSize) {
        DashIndicatorView indicatorView = new DashIndicatorView(this);
        indicatorView.setPageSize(pageSize);
        indicatorView.setIndicatorWidth(DpUtils.dp2px(8), DpUtils.dp2px(8));
        indicatorView.setSliderHeight(DpUtils.dp2px(4));
        indicatorView.setIndicatorGap(DpUtils.dp2px(5));
        indicatorView.setCheckedColor(getResources().getColor(R.color.colorAccent));
        indicatorView.setNormalColor(getResources().getColor(R.color.colorPrimary));
        return indicatorView;
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewPager.stopLoop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.startLoop();
    }
}
