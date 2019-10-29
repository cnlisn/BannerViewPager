package com.lisn.bannerview.indicator;



import android.support.v4.view.ViewPager;

import com.lisn.bannerview.enums.IndicatorSlideMode;

/**
 * Author: LiShan
 * Time: 2019-10-25  16:54
 * Description:
 */
public interface IIndicator extends ViewPager.OnPageChangeListener {
    void setPageSize(int pageSize);

    void setNormalColor(int normalColor);

    void setCheckedColor(int checkedColor);

    void setSlideMode(IndicatorSlideMode slideStyle);

    void setIndicatorGap(int gap);

    void setIndicatorWidth(int normalIndicatorWidth, int checkedIndicatorWidth);

    void notifyDataChanged();
}
