package com.zhuandian.baselibrary;

import com.zhuandian.network.HttpEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * desc:
 * author: xiedong
 * date: 3/1/21
 **/
public interface Api {
    @GET("/getAllInfoList")
    Observable<HttpEntity<List<Object>>> getAllInfoList();
}
