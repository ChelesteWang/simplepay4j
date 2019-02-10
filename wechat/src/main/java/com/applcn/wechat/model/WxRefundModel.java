package com.applcn.wechat.model;

import com.applcn.example.model.RefundModel;
import com.applcn.wechat.enums.SignTypeEnum;

/**
 * 微信退款模型
 * @author dayaoguai
 */
public class WxRefundModel implements RefundModel {

    /**
     * 签名类型
     */
    private SignTypeEnum signType;

    /**
     * 微信订单号
     * 微信生成的订单号，在支付通知中有返回
     */
    private String transactionId;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，
     * 只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String outTradeNo;

    /**
     * 商户退款单号
     * 商户系统内部的退款单号，商户系统内部唯一，
     * 只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    private String outRefundNo;

    /**
     * 订单金额
     * 订单总金额，单位为分，只能为整数
     */
    private Integer totalFee;

    /**
     * 退款金额
     * 退款总金额，订单总金额，单位为分，只能为整数
     */
    private Integer refundFee;

    /**
     * 货币种类
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY
     */
    private String refundFeeType;

    /**
     * 退款原因
     * 若商户传入，会在下发给用户的退款消息中体现退款原因
     */
    private String refundDesc;

    /**
     * 退款资金来源
     * 仅针对老资金流商户使用
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    private String refundAccount;

    /**
     * 退款结果通知url
     * 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数
     * 如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
     */
    private String notifyUrl;

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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundFeeType() {
        return refundFeeType;
    }

    public void setRefundFeeType(String refundFeeType) {
        this.refundFeeType = refundFeeType;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
