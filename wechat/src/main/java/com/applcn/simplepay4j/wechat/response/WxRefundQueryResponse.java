package com.applcn.simplepay4j.wechat.response;

import com.applcn.simplepay4j.core.annotation.XmlNode;
import com.applcn.simplepay4j.core.annotation.XmlPattern;
import com.applcn.simplepay4j.core.result.RefundQueryResult;

import java.util.List;

/**
 * 微信查询退款返回
 * @author dayaoguai
 */
public class WxRefundQueryResponse implements RefundQueryResult {

    private static final long serialVersionUID = -4563116108305756775L;

    /**
     * 返回状态码
     */
    @XmlNode("return_code")
    private String returnCode;

    /**
     * 返回信息
     */
    @XmlNode("return_msg")
    private String returnMsg;

    /**
     * 业务结果
     */
    @XmlNode("result_code")
    private String resultCode;

    /**
     * 错误代码
     */
    @XmlNode("err_code")
    private String errCode;

    /**
     * 错误代码描述
     */
    @XmlNode("err_code_des")
    private String errCodeDes;

    /**
     * 小程序ID
     */
    @XmlNode("appid")
    private String appid;

    /**
     * 商户号
     */
    @XmlNode("mch_id")
    private String mchId;

    /**
     * 随机字符串
     */
    @XmlNode("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XmlNode("sign")
    private String sign;

    /**
     * 订单总退款次数
     */
    @XmlNode("total_refund_count")
    private Integer totalRefundCount;

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
     * 货币种类
     */
    @XmlNode("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     */
    @XmlNode("cash_fee")
    private Integer cashFee;

    /**
     * 退款笔数
     */
    @XmlNode("refund_count")
    private Integer refundCount;

    /**
     * 商户退款单号
     */
    @XmlPattern("^out_refund_no_\\d+$")
    private List<String> outRefundNoList;

    /**
     * 微信退款单号
     */
    @XmlPattern("^refund_id_\\d+$")
    private List<String> refundIdList;

    /**
     * 退款渠道
     */
    @XmlPattern("^refund_channel_\\d+$")
    private List<String> refundChannelList;

    /**
     * 申请退款金额
     */
    @XmlPattern("^refund_fee_\\d+$")
    private List<String> refundFeeList;

    /**
     * 退款金额
     */
    @XmlPattern("^settlement_refund_fee_\\d+$")
    private List<String> settlementFefundFee;

    /**
     * 代金券类型
     */
    @XmlPattern("^coupon_type_\\d_\\d+$")
    private List<String> couponTypeList;

    /**
     * 总代金券退款金额
     */
    @XmlPattern("^coupon_refund_fee_\\d+$")
    private List<String> couponRefundFeeList;

    /**
     * 退款代金券使用数量
     */
    @XmlPattern("^coupon_refund_count_\\d+$")
    private List<String> couponFefundCountList;

    /**
     * 退款代金券ID
     */
    @XmlPattern("^coupon_refund_id_\\d_\\d+$")
    private List<String> couponFefundIdList;

    /**
     * 单个代金券退款金额
     */
    @XmlPattern("^coupon_refund_fee_\\d_\\d+$")
    private List<String> couponFefundFeeList;

    /**
     * 退款状态
     */
    @XmlPattern("^refund_status_\\d+$")
    private List<String> refundStatusList;

    /**
     * 退款资金来源
     */
    @XmlPattern("^refund_account_\\d+$")
    private List<String> refundAccountList;

    /**
     * 退款入账账户
     */
    @XmlPattern("^refund_recv_accout_\\d+$")
    private List<String> refundRecvAccoutList;

    /**
     * 退款成功时间
     */
    @XmlPattern("^refund_success_time_\\d+$")
    private List<String> refundSuccessTimeList;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getTotalRefundCount() {
        return totalRefundCount;
    }

    public void setTotalRefundCount(Integer totalRefundCount) {
        this.totalRefundCount = totalRefundCount;
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

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    public void setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
    }

    public Integer getRefundCount() {
        return refundCount;
    }

    public void setRefundCount(Integer refundCount) {
        this.refundCount = refundCount;
    }

    public List<String> getOutRefundNoList() {
        return outRefundNoList;
    }

    public void setOutRefundNoList(List<String> outRefundNoList) {
        this.outRefundNoList = outRefundNoList;
    }

    public List<String> getRefundIdList() {
        return refundIdList;
    }

    public void setRefundIdList(List<String> refundIdList) {
        this.refundIdList = refundIdList;
    }

    public List<String> getRefundChannelList() {
        return refundChannelList;
    }

    public void setRefundChannelList(List<String> refundChannelList) {
        this.refundChannelList = refundChannelList;
    }

    public List<String> getRefundFeeList() {
        return refundFeeList;
    }

    public void setRefundFeeList(List<String> refundFeeList) {
        this.refundFeeList = refundFeeList;
    }

    public List<String> getSettlementFefundFee() {
        return settlementFefundFee;
    }

    public void setSettlementFefundFee(List<String> settlementFefundFee) {
        this.settlementFefundFee = settlementFefundFee;
    }

    public List<String> getCouponTypeList() {
        return couponTypeList;
    }

    public void setCouponTypeList(List<String> couponTypeList) {
        this.couponTypeList = couponTypeList;
    }

    public List<String> getCouponRefundFeeList() {
        return couponRefundFeeList;
    }

    public void setCouponRefundFeeList(List<String> couponRefundFeeList) {
        this.couponRefundFeeList = couponRefundFeeList;
    }

    public List<String> getCouponFefundCountList() {
        return couponFefundCountList;
    }

    public void setCouponFefundCountList(List<String> couponFefundCountList) {
        this.couponFefundCountList = couponFefundCountList;
    }

    public List<String> getCouponFefundIdList() {
        return couponFefundIdList;
    }

    public void setCouponFefundIdList(List<String> couponFefundIdList) {
        this.couponFefundIdList = couponFefundIdList;
    }

    public List<String> getCouponFefundFeeList() {
        return couponFefundFeeList;
    }

    public void setCouponFefundFeeList(List<String> couponFefundFeeList) {
        this.couponFefundFeeList = couponFefundFeeList;
    }

    public List<String> getRefundStatusList() {
        return refundStatusList;
    }

    public void setRefundStatusList(List<String> refundStatusList) {
        this.refundStatusList = refundStatusList;
    }

    public List<String> getRefundAccountList() {
        return refundAccountList;
    }

    public void setRefundAccountList(List<String> refundAccountList) {
        this.refundAccountList = refundAccountList;
    }

    public List<String> getRefundRecvAccoutList() {
        return refundRecvAccoutList;
    }

    public void setRefundRecvAccoutList(List<String> refundRecvAccoutList) {
        this.refundRecvAccoutList = refundRecvAccoutList;
    }

    public List<String> getRefundSuccessTimeList() {
        return refundSuccessTimeList;
    }

    public void setRefundSuccessTimeList(List<String> refundSuccessTimeList) {
        this.refundSuccessTimeList = refundSuccessTimeList;
    }
}
