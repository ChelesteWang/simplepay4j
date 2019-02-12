package com.applcn.simplepay4j.wechat;

import com.applcn.simplepay4j.core.handler.MethodHandler;
import com.applcn.simplepay4j.core.handler.NotifyHandler;
import com.applcn.simplepay4j.core.proxy.MethodProxy;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;
import com.applcn.simplepay4j.core.utils.StringUtil;
import com.applcn.simplepay4j.core.utils.XmlUtil;
import com.applcn.simplepay4j.wechat.method.WxMethodRequest;
import com.applcn.simplepay4j.wechat.method.WxNotifyManage;
import com.applcn.simplepay4j.wechat.model.WxAccountModel;
import com.applcn.simplepay4j.wechat.model.WxOrderModel;

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
     * 回调管理
     * @param in
     * @param key
     * @return
     * @throws Exception
     */
    public static NotifyManageProxy notifyManage(InputStream in, String key) throws Exception {
        WxOrderModel model = XmlUtil.xmlToPojo(StringUtil.getString(in), WxOrderModel.class);
        NotifyHandler handler = new NotifyHandler(model, key);
        NotifyManageProxy proxy = (NotifyManageProxy) Proxy.newProxyInstance(WxNotifyManage.class.getClassLoader(),
                WxNotifyManage.class.getInterfaces(), handler);
        return proxy;
    }
}
