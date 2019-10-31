

package com.lisn.BannerViewPager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lisn.BannerViewPager.R;

/**
 *   Created by LiShan on 2019-10-25.
 *   Description:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_custom_indicator:
                intent = new Intent(this, CustomIndicatorActivity.class);
                break;
            case R.id.btn_view_pager3:
                intent = new Intent(this, BannerPhotoViewActivity.class);
                break;
            case R.id.btn_view_pager4:
                intent = new Intent(this, NetworkBannerActivity.class);
                break;
            case R.id.btn_view_pager5:
                intent = new Intent(this, PageTransformerActivity.class);
                break;
            case R.id.btn_indicator_style:
                intent = new Intent(this, IndicatorStyleActivity.class);
                break;
            case R.id.btn_liuhai:
                intent = new Intent(this, LuiHaiActivity.class);
                break;
            default:
                intent = new Intent(this, CustomerBannerItemActivity.class);
                break;
        }
        startActivity(intent);
    }
}
