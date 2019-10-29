package com.lisn.bannerview.indicator;

import android.content.Context;

import com.lisn.bannerview.enums.IndicatorStyle;

public class IndicatorFactory {
    public static BaseIndicatorView createIndicatorView(Context context, IndicatorStyle indicatorStyle) {
        BaseIndicatorView indicatorView;
        if (indicatorStyle == IndicatorStyle.DASH) {
            indicatorView = new DashIndicatorView(context);
        } else {
            indicatorView = new CircleIndicatorView(context);
        }
        return indicatorView;
    }
}
