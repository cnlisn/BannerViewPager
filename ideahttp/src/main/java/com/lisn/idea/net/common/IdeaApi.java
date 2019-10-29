package com.lisn.idea.net.common;

import retrofit2.Retrofit;

/**
 * Author: LiShan
 * Time: 2019-10-29
 * Description:
 */

public class IdeaApi {
    public static <T> T getApiService(Class<T> cls, String baseUrl) {
        Retrofit retrofit = RetrofitUtils.getRetrofitBuilder(baseUrl).build();
        return retrofit.create(cls);
    }
}
