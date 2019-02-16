package com.applcn.simplepay4j.wechat.model;

import com.applcn.simplepay4j.core.model.RefundQueryModel;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;

/**
 * 微信查询退款模型
 * @author dayaoguai
 */
public class WxRefundQueryModel implements RefundQueryModel {

    /**
     * 签名类型
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     * 非必填
     */
    private SignTypeEnum signType;

    /**
     * 微信订单号
     * 微信的订单号，优先使用
     * 和商户订单号 商户退款单号 微信退款单号四选一
     */
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
     * 和微信订单号 商户退款单号 微信退款单号四选一
     */
    private String outTradeNo;

    /**
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔
     * 和微信订单号 商户订单号 微信退款单号四选一
     */
    private String outRefundNo;

    /**
     * 微信退款单号
     * 微信生成的退款单号，在申请退款接口有返回
     * 和微信订单号 商户订单号 商户退款单号四选一
     */
    private String refundId;

    /**
     * 偏移量
     * 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     */
    private String offset;

    public WxRefundQueryModel() {
    }

    public WxRefundQueryModel(String transactionId) {
        this.transactionId = transactionId;
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
