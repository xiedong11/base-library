package com.zhuandian.base;


import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


abstract public class WebPageActivity extends BaseActivity {


    private WebView wvPage;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_page;
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    protected void setUpView() {
        wvPage = findViewById(R.id.wv_page);
        swipeRefreshLayout = findViewById(R.id.srl_refresh);
        wvPage.getSettings().setJavaScriptEnabled(true);
        wvPage.getSettings().setDomStorageEnabled(true);
        wvPage.setWebViewClient(new WebViewClient());
        wvPage.setWebChromeClient(new WebChromeClient());
        wvPage.loadUrl(getUrl());

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                wvPage.reload();
            }
        });

        swipeRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view) {
                return wvPage.getScrollY() > 0;  // 原生安卓使用getScrollY()来判断在Y轴的距离
//                return wvPage.getWebScrollY() > 0;   // X5内核的webview需要调用getWebScrollY()来判断在Y轴的距离
            }
        });
    }

    abstract public String getUrl();

    @Override
    public void onBackPressed() {
        if (wvPage.canGoBack())
            wvPage.goBack();
        else
            super.onBackPressed();
    }
}
