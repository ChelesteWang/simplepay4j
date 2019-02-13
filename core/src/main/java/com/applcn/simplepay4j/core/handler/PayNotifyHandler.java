package com.applcn.simplepay4j.core.handler;

import com.applcn.simplepay4j.core.model.PayOrderModel;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 回调代理处理类
 * @author dayaoguai
 */
public class PayNotifyHandler implements InvocationHandler {

    private NotifyManageProxy subject;

    private String key;

    private PayOrderModel payOrderModel;

    public PayNotifyHandler(PayOrderModel payOrderModel, String key) {
        this.payOrderModel = payOrderModel;
        this.key = key;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.subject = payOrderModel.init();
        this.subject.init(payOrderModel, key);
        Object result = method.invoke(subject, args);
        System.gc();
        return result;
    }
}
