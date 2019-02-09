package com.applcn.wechat;

import com.applcn.wechat.core.handler.MethodHandler;
import com.applcn.wechat.core.handler.NotifyHandler;
import com.applcn.wechat.core.proxy.MethodProxy;
import com.applcn.wechat.core.proxy.NotifyManageProxy;
import com.applcn.wechat.core.utils.StringUtil;
import com.applcn.wechat.core.utils.XmlUtil;
import com.applcn.wechat.method.WxMethodRequest;
import com.applcn.wechat.method.WxNotifyManage;
import com.applcn.wechat.model.WxAccountModel;
import com.applcn.wechat.model.WxOrderModel;

import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * 微信支付方法
 * @author dayaoguai
 */
public class Wechat {

    /**
     * 统一下单
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
