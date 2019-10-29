package com.lisn.BannerViewPager;

import android.app.Application;

import com.lisn.BannerViewPager.imageloader.GlideImageLoader;
import com.lisn.BannerViewPager.imageloader.ImageLoaderManager;
import com.lisn.idea.utils.Utils;
/**
 * Author: LiShan 
 * Time: 2019-10-29  
 * Description: 
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderManager.getInstance().init(new GlideImageLoader());
        Utils.init(getApplicationContext());
    }
}