package com.lisn.BannerViewPager.net;


import com.lisn.idea.net.common.IdeaApi;

/**
 * Author: LiShan 
 * Time: 2019-10-28  
 * Description:
 */
public class RetrofitGnerator {
    private static ApiService mApiservice;

    public static ApiService getApiSerVice() {
        if (mApiservice == null) {
            mApiservice = IdeaApi.getApiService(ApiService.class, Constants.BASE_URL);
        }
        return mApiservice;
    }
}
