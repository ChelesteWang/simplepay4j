package com.applcn.simplepay4j.wechat;

import com.applcn.simplepay4j.core.handler.MethodHandler;
import com.applcn.simplepay4j.core.handler.PayNotifyHandler;
import com.applcn.simplepay4j.core.proxy.MethodProxy;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;
import com.applcn.simplepay4j.core.utils.StringUtil;
import com.applcn.simplepay4j.core.utils.XmlUtil;
import com.applcn.simplepay4j.wechat.method.WxMethodRequest;
import com.applcn.simplepay4j.wechat.method.WxPayNotifyManage;
import com.applcn.simplepay4j.wechat.model.WxAccountModel;
import com.applcn.simplepay4j.wechat.model.WxPayPayOrderModel;
import com.applcn.simplepay4j.wechat.model.WxRefundNotifyModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * 微信支付方法
 * @author dayaoguai
 */
public class Wechat {

    /**
     * 请求方法
     * @param wxAccountModel
     * @return
     */
    public static MethodProxy orderMethod(WxAccountModel wxAccountModel){
        MethodHandler handler = new MethodHandler(wxAccountModel);
        MethodProxy proxy = (MethodProxy) Proxy.newProxyInstance(WxMethodRequest.class.getClassLoader(),
                WxMethodRequest.class.getInterfaces(), handler);
        return proxy;
    }

    /**
     * 支付回调管理
     * @param in
     * @param key
     * @return
     * @throws Exception
     */
    public static NotifyManageProxy payNotifyManage(InputStream in, String key) throws Exception {
        WxPayPayOrderModel model = XmlUtil.xmlToPojo(StringUtil.getString(in), WxPayPayOrderModel.class);
        PayNotifyHandler handler = new PayNotifyHandler(model, key);
        NotifyManageProxy proxy = (NotifyManageProxy) Proxy.newProxyInstance(WxPayNotifyManage.class.getClassLoader(),
                WxPayNotifyManage.class.getInterfaces(), handler);
        return proxy;
    }

    /**
     * 退款回调管理
     * @param key
     * @return
     * @throws Exception
     */
    public static MethodProxy refundNotifyManage(String key) throws Exception {
        WxAccountModel wxAccountModel = new WxAccountModel();
        wxAccountModel.setKey(key);
        MethodHandler handler = new MethodHandler(wxAccountModel);
        MethodProxy proxy = (MethodProxy) Proxy.newProxyInstance(WxMethodRequest.class.getClassLoader(),
                WxMethodRequest.class.getInterfaces(), handler);
        return proxy;
    }
}
