package com.zhuandian.network;

/**
 * desc:
 * author: xiedong
 * date: 9/24/20
 **/

public interface CallBack<T> {
    void onSuccess(T result);

    void onError(Exception e);
}
