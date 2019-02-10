package com.applcn.wechat.model;

import com.applcn.example.model.OrderQueryModel;
import com.applcn.wechat.enums.SignTypeEnum;

/**
 * 微信支付订单查询模型
 * @author dayaoguai
 */
public class WxOrderQueryModel implements OrderQueryModel {

    /**
     * 微信订单号
     * 微信的订单号，优先使用
     * 和商户订单号二选一
     */
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     * 和微信订单号二选一
     */
    private String outTradeNo;

    /**
     * 签名类型
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     * 非必填
     */
    private SignTypeEnum signType;

    public WxOrderQueryModel() {
    }

    public WxOrderQueryModel(String transactionId) {
        this.transactionId = transactionId;
    }

    public void expand(SignTypeEnum signType){
        this.signType = signType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
