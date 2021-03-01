package com.zhuandian.baselibrary;


import android.os.Bundle;

import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpEntity;
import com.zhuandian.network.HttpManager;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
    }



    @OnClick(R.id.btn_vlayout)
    public void onClick() {

        Observable<HttpEntity<List<Object>>> observable = getApiService().getAllInfoList();
        HttpManager.getInstance().doHttpRequest(activity,observable, new CallBack<List<Object>>() {
            @Override
            public void onSuccess(List<Object> result) {
                List<Object> result1 = result;
            }

            @Override
            public void onError(Exception e) {
                String message = e.getMessage();
            }
        });
    }
}
