package com.lisn.bannerview.view;

import android.content.Context;


import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 *  Author: LiShan
 *  Time: 2019-10-25  16:48
 *  Description:处理嵌套PhotoView缩放引起的crash.
 */
public class CatchViewPager extends ViewPager {
    public CatchViewPager(Context context) {
        this(context, null);
    }

    public CatchViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
