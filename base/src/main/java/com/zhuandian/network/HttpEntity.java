package com.zhuandian.network;

/**
 * desc :http返回实体包装类
 * author：xiedong
 * data：2018/11/1
 */
public class HttpEntity<T> {
    private int code;
    private T data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
