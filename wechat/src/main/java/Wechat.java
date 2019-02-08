
import com.applcn.core.handler.MethodHandler;
import com.applcn.core.handler.NotifyHandler;
import com.applcn.core.proxy.MethodProxy;
import com.applcn.core.proxy.NotifyManageProxy;
import com.applcn.core.utils.StringUtil;
import com.applcn.core.utils.XmlUtil;
import method.WxMethodRequest;
import method.WxNotifyManage;
import model.WxAccountModel;
import model.WxOrderModel;

import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * 微信支付方法
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
