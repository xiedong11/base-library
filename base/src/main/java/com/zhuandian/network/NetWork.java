package com.zhuandian.network;

/**
 * desc :网络配置类
 * author：xiedong
 * data：2018/11/2
 */
public class NetWork {
    //接口地址
    public static String API_BASE_URL;
    //true 测试平台  false 线上环境
    private static boolean DEBUG = false;

    public static void initNewWork() {
        if (DEBUG) {
            //测试平台
            API_BASE_URL = "http://test.zhuandian.site/";
        } else {
            //线上正式环境
            API_BASE_URL = "https://gitee.com";
        }
    }

    public static String MAIN_URL_DEBUG = "http://172.16.0.108:3000/#/"; //本地测试地址
    //储存前端项目主域名
    public static String MAIN_URL_RELEASE = "https://ydjw.github.io/jwc/#/";

    /**
     * 获取前端主路由
     *
     * @return
     */
    public static String getMainUrl() {
        return DEBUG ? MAIN_URL_DEBUG : MAIN_URL_RELEASE;
    }
}
