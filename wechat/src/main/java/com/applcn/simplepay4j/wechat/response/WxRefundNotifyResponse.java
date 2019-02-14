package com.applcn.simplepay4j.wechat.response;

import com.applcn.simplepay4j.core.annotation.XmlNode;
import com.applcn.simplepay4j.core.result.RefundNotifyResult;

/**
 * 退款回调结果
 * @author dayaoguai
 */
public class WxRefundNotifyResponse implements RefundNotifyResult {

    private static final long serialVersionUID = -3662393866761636888L;

    /**
     * 微信订单号
     */
    @XmlNode("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     */
    @XmlNode("out_trade_no")
    private String outTradeNo;

    /**
     * 微信退款单号
     */
    @XmlNode("refund_id")
    private String refundId;

    /**
     * 商户退款单号
     */
    @XmlNode("out_refund_no")
    private String outRefundNo;

    /**
     * 订单金额
     */
    @XmlNode("total_fee")
    private Integer totalFee;

    /**
     * 应结订单金额
     */
    @XmlNode("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 退款状态
     * SUCCESS-退款成功
     * CHANGE-退款异常
     * REFUNDCLOSE—退款关闭
     */
    @XmlNode("refund_status")
    private String refundFtatus;

    /**
     * 退款成功时间
     * 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
     */
    @XmlNode("success_time")
    private String successTime;

    /**
     * 退款入账账户
     */
    @XmlNode("refund_recv_accout")
    private String refundRecvAccout;

    /**
     * 退款资金来源
     */
    @XmlNode("refund_account")
    private String refundAccount;

    /**
     * 退款发起来源
     */
    @XmlNode("refund_request_source")
    private String refundRequestSource;

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

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
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

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getRefundFtatus() {
        return refundFtatus;
    }

    public void setRefundFtatus(String refundFtatus) {
        this.refundFtatus = refundFtatus;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getRefundRecvAccout() {
        return refundRecvAccout;
    }

    public void setRefundRecvAccout(String refundRecvAccout) {
        this.refundRecvAccout = refundRecvAccout;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getRefundRequestSource() {
        return refundRequestSource;
    }

    public void setRefundRequestSource(String refundRequestSource) {
        this.refundRequestSource = refundRequestSource;
    }
}
