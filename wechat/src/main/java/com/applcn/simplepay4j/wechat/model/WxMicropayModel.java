package com.applcn.simplepay4j.wechat.model;

import com.applcn.simplepay4j.core.model.MicropayModel;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;
import com.applcn.simplepay4j.wechat.enums.TradeTypeEnum;

import java.lang.reflect.InvocationTargetException;

/**
 * 微信提交付款码支付模型
 * @author dayaoguai
 */
public class WxMicropayModel extends WxUnifiedOrderModel implements MicropayModel {

    /**
     * 授权码
     * 扫码支付授权码，设备读取用户微信中的条码或者二维码信息
     * （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    private String authCode;

    public WxMicropayModel() {
    }

    public WxMicropayModel(String body, String outTradeNo, int totalFee, String spbillCreateIp, String authCode) {
        super(body, outTradeNo, totalFee, spbillCreateIp, null, null);
        this.authCode = authCode;
    }

    @Override
    public void expand(SignTypeEnum signType) {
        super.expand(signType);
    }

    @Override
    public void expand(String... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        super.expand(params);
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
