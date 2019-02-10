package com.applcn.example.handler;

import com.applcn.example.proxy.NotifyManageProxy;
import com.applcn.example.model.OrderModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 回调代理处理类
 * @author dayaoguai
 */
public class NotifyHandler implements InvocationHandler {

    private NotifyManageProxy subject;

    private String key;

    private OrderModel orderModel;

    public NotifyHandler(OrderModel orderModel, String key) {
        this.orderModel = orderModel;
        this.key = key;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.subject = orderModel.init();
        this.subject.init(orderModel, key);
        Object result = method.invoke(subject, args);
        System.gc();
        return result;
    }
}
