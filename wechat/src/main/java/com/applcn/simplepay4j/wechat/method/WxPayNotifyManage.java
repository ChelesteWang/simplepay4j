package com.applcn.simplepay4j.wechat.method;

import com.applcn.simplepay4j.core.model.PayOrderModel;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;
import com.applcn.simplepay4j.core.utils.MapUtil;
import com.applcn.simplepay4j.core.utils.StringUtil;
import com.applcn.simplepay4j.wechat.model.WxPayPayOrderModel;
import com.applcn.simplepay4j.wechat.util.SignUtil;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;

import java.util.Map;

/**
 * 回调管理
 * @author dayaoguai
 */
public class WxPayNotifyManage implements NotifyManageProxy {

    private WxPayPayOrderModel model;

    private String key;

    @Override
    public void init(PayOrderModel payOrderModel, String key) {
        this.model = (WxPayPayOrderModel) payOrderModel;
        this.key = key;
    }

    @Override
    public WxPayPayOrderModel manage() throws Exception {
        String sign = model.getSign();
        SignTypeEnum signType = SignTypeEnum.MD5;
        if (!StringUtil.isEmpty(model.getSignType())) {
            signType = SignTypeEnum.valueOf(model.getSignType());
        }
        Map<String,String> params = MapUtil.pojoToMap(model);
        String checkSign = SignUtil.sign(params, this.key, signType);
        if(sign.equalsIgnoreCase(checkSign)){
            return model;
        }else{
            return null;
        }
    }
}
