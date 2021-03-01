package com.zhuandian.network;

import android.content.Context;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc :网络请求管理类-对retrofit封装
 * author：xiedong
 * data：2018/11/1
 */
public class HttpManager {
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private ApiService apiService;
    private static HttpManager sInstance;

    private HttpManager() {
    }

    public static HttpManager getInstance() {
        if (sInstance == null) {
            sInstance = new HttpManager();
        }
        return sInstance;
    }

    private OkHttpClient getHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(getHttpLoggingInterceptor())
                .build();
        return client;
    }

    private Interceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                Log.v("OKHttp-----", message);
            }
        });
//        NONE,BASIC,HEADER,BODY
//        BASEIC:请求/响应行
//        HEADERS:请求/响应行 + 头
//        BODY:请求/响应航 + 头 + 体
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    public Retrofit createRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();

        return retrofit;
    }


    public <T> void doHttpRequest(Context context, Observable<HttpEntity<T>> observable, final CallBack callBack) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HttpEntity<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HttpEntity<T> tHttpEntity) {
                        if (tHttpEntity != null && tHttpEntity.getData() != null) {
                            callBack.onSuccess(tHttpEntity.getData());
                        } else {
                            callBack.onError(new Exception("no data"));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(new Exception(e.toString()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
