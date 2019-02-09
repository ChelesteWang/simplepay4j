package com.applcn.wechat.method;

import com.applcn.wechat.core.model.OrderModel;
import com.applcn.wechat.core.proxy.NotifyManageProxy;
import com.applcn.wechat.core.utils.MapUtil;
import com.applcn.wechat.enums.SignTypeEnum;
import com.applcn.wechat.model.WxOrderModel;
import com.applcn.wechat.util.SignUtil;

import java.util.Map;

/**
 * 回调管理
 * @author dayaoguai
 */
public class WxNotifyManage implements NotifyManageProxy {

    private WxOrderModel model;

    private String key;

    @Override
    public void init(OrderModel orderModel, String key) {
        this.model = (WxOrderModel) orderModel;
        this.key = key;
    }

    @Override
    public WxOrderModel manage() throws Exception {
        String sign = model.getSign();
        SignTypeEnum signType = SignTypeEnum.valueOf(model.getSign());
        model.setSign(null);
        Map<String,String> params = MapUtil.pojoToMap(model);
        String checkSign = SignUtil.sign(params, this.key, signType);
        if(sign.equals(checkSign)){
            return model;
        }else{
            return null;
        }
    }
}
