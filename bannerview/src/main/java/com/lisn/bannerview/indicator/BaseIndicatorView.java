package com.lisn.bannerview.indicator;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


import com.lisn.bannerview.enums.IndicatorSlideMode;
import com.lisn.bannerview.utils.DpUtils;

/**
 * Author: LiShan
 * Time: 2019-10-25  16:54
 * Description:IndicatorView基类，处理了页面滑动。
 */
public class BaseIndicatorView extends View implements IIndicator {
    /**
     * 页面size
     */
    protected int pageSize;
    /**
     * 未选中时Indicator颜色
     */
    protected int normalColor;
    /**
     * 选中时Indicator颜色
     */
    protected int checkedColor;
    /**
     * Indicator间距
     */
    protected float indicatorGap;
    /**
     * 从一个点滑动到另一个点的进度
     */
    protected float slideProgress;
    /**
     * 指示器当前位置
     */
    protected int currentPosition;
    /**
     * 指示器上一个位置
     */
    private int prePosition;
    /**
     * 是否是向右滑动，true向右，false向左
     */
    protected boolean slideToRight;
    /**
     * Indicator滑动模式，目前仅支持两种
     *
     * @see IndicatorSlideMode#NORMAL
     * @see IndicatorSlideMode#SMOOTH
     */
    protected IndicatorSlideMode slideMode;

    protected float normalIndicatorWidth;
    protected float checkedIndicatorWidth;

    public BaseIndicatorView(Context context) {
        super(context);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        normalIndicatorWidth = DpUtils.dp2px(8);
        checkedIndicatorWidth = normalIndicatorWidth;
        indicatorGap = normalIndicatorWidth;
        normalColor = Color.parseColor("#8C18171C");
        checkedColor = Color.parseColor("#8C6C6D72");
        slideMode = IndicatorSlideMode.NORMAL;
    }

    @Override
    public void onPageSelected(int position) {
        if (slideMode == IndicatorSlideMode.NORMAL) {
            currentPosition = position;
            slideProgress = 0;
            invalidate();
        } else if (slideMode == IndicatorSlideMode.SMOOTH) {
            if (position == 0 && slideToRight) {
//                    Log.e(tag, "slideToRight position-----》" + position);
                currentPosition = 0;
                slideProgress = 0;
                invalidate();

            } else if (position == pageSize - 1 && !slideToRight) {
                currentPosition = pageSize - 1;
                slideProgress = 0;
                invalidate();
            }
        }
    }

    private static final String tag = "BaseIndicatorView";

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (slideMode == IndicatorSlideMode.SMOOTH) {
            if ((prePosition == 0 && position == pageSize - 1)) {
                slideToRight = false;
            } else if (prePosition == pageSize - 1 && position == 0) {
//                Log.e(tag, "prePosition-----》" + prePosition);
//                Log.e(tag, "position-----》" + position);
                slideToRight = true;
            } else {
                slideToRight = (position + positionOffset - prePosition) > 0;
            }
            //  TODO 解决滑动过快时positionOffset不会等0的情况
            if (positionOffset == 0) {
                prePosition = position;
            }
            if (!(position == pageSize - 1 && slideToRight || (position == pageSize - 1 && !slideToRight))) {
                slideProgress = (currentPosition == pageSize - 1) && slideToRight ? 0 : positionOffset;
                currentPosition = position;
                invalidate();
            }
        }
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        requestLayout();
    }

    @Override
    public void setNormalColor(int normalColor) {
        this.normalColor = normalColor;
    }

    @Override
    public void setCheckedColor(int checkedColor) {
        this.checkedColor = checkedColor;
    }


    /**
     * @param gapRes Indicator间距
     */
    public void setIndicatorGap(int gapRes) {
        if (gapRes >= 0) {
            this.indicatorGap = gapRes;
        }
    }

    /**
     * @param slideMode Indicator滑动样式
     * @see IndicatorSlideMode#NORMAL
     * @see IndicatorSlideMode#SMOOTH
     */
    @Override
    public void setSlideMode(IndicatorSlideMode slideMode) {
        this.slideMode = slideMode;
    }

    /**
     * Indicator Slider width or the diameter of circle.
     *
     * @param normalIndicatorWidth  未选中Slider width
     * @param checkedIndicatorWidth 选中Slider width
     */
    @Override
    public void setIndicatorWidth(int normalIndicatorWidth, int checkedIndicatorWidth) {
        this.normalIndicatorWidth = normalIndicatorWidth;
        this.checkedIndicatorWidth = checkedIndicatorWidth;
    }

    @Override
    public void notifyDataChanged() {
        invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
