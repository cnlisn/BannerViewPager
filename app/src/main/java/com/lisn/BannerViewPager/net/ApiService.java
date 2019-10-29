package com.lisn.BannerViewPager.net;



import com.lisn.BannerViewPager.bean.ArticleWrapper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Author: LiShan
 * Time: 2019-10-28
 * Description:
 */
public interface ApiService {
    @GET("banner/json")
    Observable<List<BannerData>> getBannerData();

    @GET("article/list/0/json")
    Observable<ArticleWrapper> getArticle();
}
