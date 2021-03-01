package com.zhuandian.baselibrary;

/**
 * desc:
 * author: xiedong
 * date: 3/1/21
 **/
abstract public class BaseActivity extends com.zhuandian.base.BaseActivity {

    @Override
    protected <T> T getBaseApiClass() {
        return (T) Api.class;
    }

    @Override
    protected String getBaseUrl() {
        return "http://192.168.51.109:8080/";
    }

    public Api getApiService(){
        return activity.getApiService();
    }
}
