package com.applcn.simplepay4j.wechat.method;

import com.applcn.simplepay4j.core.model.OrderModel;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;
import com.applcn.simplepay4j.core.utils.MapUtil;
import com.applcn.simplepay4j.wechat.model.WxOrderModel;
import com.applcn.simplepay4j.wechat.util.SignUtil;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;

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
