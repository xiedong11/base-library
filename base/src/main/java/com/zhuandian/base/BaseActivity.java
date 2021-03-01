package com.zhuandian.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zhuandian.eventhub.BaseEvent;
import com.zhuandian.eventhub.BindEventBus;
import com.zhuandian.network.ApiService;
import com.zhuandian.network.HttpManager;
import com.zhuandian.network.NetWork;
import com.zhuandian.utils.AppManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * desc :
 * author：xiedong
 * date：2019/2/19
 */
abstract public class BaseActivity extends AppCompatActivity {


    public BaseActivity activity;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        AppManager.getInstance().addActivity(this);
        activity = this;
        ButterKnife.bind(this);
        setUpView();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }

    protected abstract int getLayoutId();

    protected abstract void setUpView();

    @Override
    protected void onDestroy() {
        AppManager.getInstance().reomveActivity(this);
        super.onDestroy();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 使用EventBus直接复写该方法：统一规范子类使用eventBus命名规范
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventBusReceiver(BaseEvent event) {

    }

    public <T> T getApiService() {
        return HttpManager.getInstance().createRetrofit(getBaseUrl()).create((Class<T>) getBaseApiClass());
    }

    /**
     * 设置全局接口服务
     * @param <T>
     * @return
     */
    protected abstract <T> T getBaseApiClass();


    /**
     * 设置网络层baseUrl
     */
    protected abstract String getBaseUrl();

}
