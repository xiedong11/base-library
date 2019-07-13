package com.zhuandian.baselibrary;


import android.os.Bundle;

import com.zhuandian.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
    }
}
