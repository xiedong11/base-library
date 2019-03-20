package com.zhuandian.eventhub;

/**
 * desc :抽象event事件
 * author：xiedong
 * data：2018/9/17
 */
public abstract class BaseEvent<T> {
    public Class<?> from; //事件来源
    public T eventContent; //事件内容
    public int eventTyep;  //事件类型

}
