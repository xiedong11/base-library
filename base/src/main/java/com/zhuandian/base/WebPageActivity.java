package com.zhuandian.base;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


abstract public class WebPageActivity extends BaseActivity {


    private WebView wvPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_page;
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    protected void setUpView() {
        wvPage = findViewById(R.id.wv_page);
        wvPage.getSettings().setJavaScriptEnabled(true);
        wvPage.getSettings().setDomStorageEnabled(true);
        wvPage.setWebViewClient(new WebViewClient());
        wvPage.setWebChromeClient(new WebChromeClient());
        wvPage.loadUrl(getUrl());
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
