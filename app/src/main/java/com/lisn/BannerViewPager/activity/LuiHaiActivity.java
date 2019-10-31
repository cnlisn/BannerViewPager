package com.lisn.BannerViewPager.activity;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lisn.BannerViewPager.R;
import com.lisn.BannerViewPager.utils.Notch.NotchUtils;

/**
 * Author: LiShan
 * Time: 2019-10-30
 * Description: 刘海屏
 */
public class LuiHaiActivity extends AppCompatActivity {

    private TextView t_check;
    private TextView t_h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lui_hai);
        t_check = findViewById(R.id.t_check);
        t_h = findViewById(R.id.t_H);
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.checkIsLiuHai:
                boolean b = hasNotch(this);
                t_check.setText("hasNotch = " + b);
                break;
            case R.id.getH:
                int notchH = getNotchH(this);
                t_h.setText("Height = " + notchH);
                break;
        }
    }

    private int getNotchH(Context context) {
        int height = NotchUtils.getStatusBarHeight(context);
        String manufacturer = Build.MANUFACTURER;
        if ("HUAWEI".equalsIgnoreCase(manufacturer)) {
            int[] notchSizeAtHuawei = NotchUtils.getNotchSizeAtHuawei(context);
            height = notchSizeAtHuawei[1];
        } else if ("xiaomi".equalsIgnoreCase(manufacturer)) {
            height = NotchUtils.getNotHeightAtXiaomi(context);
        }
        return height;
    }


    private boolean hasNotch(Context context) {
        boolean ret = false;
        String manufacturer = Build.MANUFACTURER;
        if ("oppo".equalsIgnoreCase(manufacturer)) {
            ret = NotchUtils.hasNotchAtOppo(context);
        } else if ("vivo".equalsIgnoreCase(manufacturer)) {
            ret = NotchUtils.hasNotchAtVivo(context);
        } else if ("HUAWEI".equalsIgnoreCase(manufacturer)) {
            ret = NotchUtils.hasNotchAtHuawei(context);
        } else if ("xiaomi".equalsIgnoreCase(manufacturer)) {
            ret = NotchUtils.hasNotchAtXiaomi(context);
        }
        return ret;
    }
}
