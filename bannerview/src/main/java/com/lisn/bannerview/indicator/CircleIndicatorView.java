package com.lisn.bannerview.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Author: LiShan
 * Time: 2019-10-25  16:54
 * Description:
 */
public class CircleIndicatorView extends BaseIndicatorView {
    private static final String tag = "IndicatorView";
    private Paint mPaint;
    private float mNormalRadius;
    private float mCheckedRadius;
    private float maxRadius;
    private int height;

    public CircleIndicatorView(Context context) {
        this(context, null);
    }

    public CircleIndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(normalColor);
        mPaint.setAntiAlias(true);
        mNormalRadius = normalIndicatorWidth / 2;
        mCheckedRadius = checkedIndicatorWidth / 2;
        indicatorGap = mNormalRadius * 2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = getHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mNormalRadius = normalIndicatorWidth / 2;
        mCheckedRadius = checkedIndicatorWidth / 2;
        maxRadius = Math.max(mCheckedRadius, mNormalRadius);
        setMeasuredDimension((int) ((pageSize - 1) * indicatorGap + 2 * maxRadius * pageSize),
                (int) (2 * maxRadius));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < pageSize; i++) {
            mPaint.setColor(normalColor);
            canvas.drawCircle(maxRadius + (2 * mNormalRadius + indicatorGap) * i, height / 2f, mNormalRadius, mPaint);
        }
        drawSliderStyle(canvas);
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
    }

    private void drawSliderStyle(Canvas canvas) {
        mPaint.setColor(checkedColor);
        canvas.drawCircle(maxRadius + (2 * mNormalRadius + indicatorGap) * currentPosition + (2 * mNormalRadius + indicatorGap) * slideProgress,
                height / 2f, mCheckedRadius, mPaint);
    }
}
