package com.lisn.BannerViewPager.bean;


import com.lisn.BannerViewPager.net.BannerData;

import java.util.List;

public class DataWrapper {

    private List<ArticleWrapper.Article> articleList;

    private List<BannerData> dataBeanList;

    public List<BannerData> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<BannerData> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }


    public List<ArticleWrapper.Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleWrapper.Article> articleList) {
        this.articleList = articleList;
    }


}
