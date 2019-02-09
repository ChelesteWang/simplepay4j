package com.applcn.wechat.model;

import com.applcn.wechat.core.model.CloseOrderModel;
import com.applcn.wechat.enums.SignTypeEnum;

/**
 * 微信关闭订单模型
 * @author dayaoguai
 */
public class WxCloseOrderModel implements CloseOrderModel {

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，
     * 只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String outTradeNo;

    /**
     * 签名类型
     */
    private SignTypeEnum signType;

    public WxCloseOrderModel() {
    }

    public WxCloseOrderModel(String outTradeNo, SignTypeEnum signType) {
        this.outTradeNo = outTradeNo;
        this.signType = signType;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
        this.signType = signType;
    }
}
