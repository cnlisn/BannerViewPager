package com.lisn.bannerview.utils;

import android.content.res.Resources;

/**
 * Author: LiShan
 * Time: 2019-10-25  16:50
 * Description:
 */
public class DpUtils {

    public float density;

    public DpUtils() {
        this.density = Resources.getSystem().getDisplayMetrics().density;
    }

    public static int dp2px(float dpValue) {
        return (int)(0.5F + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float px2dp(float pxValue) {
        return pxValue / Resources.getSystem().getDisplayMetrics().density;
    }

    public int dip2px(float dpValue) {
        return (int)(0.5F + dpValue * this.density);
    }

    public float px2dip(int pxValue) {
        return (float)pxValue / this.density;
    }
}
