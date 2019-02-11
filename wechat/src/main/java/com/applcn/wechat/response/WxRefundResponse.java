package com.applcn.wechat.response;

import com.applcn.example.annotation.XmlNode;
import com.applcn.example.annotation.XmlPattern;
import com.applcn.example.result.RefundResult;

import java.util.List;

/**
 * 微信退款返回
 * @author dayaoguai
 */
public class WxRefundResponse implements RefundResult {

    private static final long serialVersionUID = 7045620575490713760L;

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
     * 商户退款单号
     */
    @XmlNode("out_refund_no")
    private String outFefundNo;

    /**
     * 微信退款单号
     */
    @XmlNode("refund_id")
    private String refundId;

    /**
     * 退款金额
     */
    @XmlNode("refund_fee")
    private Integer refundFee;

    /**
     * 应结退款金额
     */
    @XmlNode("settlement_refund_fee")
    private Integer settlementFefundFee;

    /**
     * 标价金额
     */
    @XmlNode("total_fee")
    private Integer totalFee;

    /**
     * 应结订单金额
     */
    @XmlNode("settlement_total_fee")
    private Integer settlementTotalFee;

    /**
     * 标价币种
     */
    @XmlNode("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     */
    @XmlNode("cash_fee")
    private Integer cashFee;

    /**
     * 现金支付币种
     */
    @XmlNode("cash_fee_type")
    private String cashFeeType;

    /**
     * 代金券类型
     */
    @XmlNode("cash_refund_fee")
    private String cashFefundFee;

    /**
     * 代金券退款总金额
     */
    @XmlNode("coupon_refund_fee")
    private String couponFefundFee;

    /**
     * 退款代金券使用数量
     */
    @XmlNode("coupon_refund_count")
    private String couponFefundCount;

    /**
     * 代金券类型
     */
    @XmlPattern("^coupon_type_\\d+$")
    private List<String> couponTypeList;

    /**
     * 单个代金券退款金额
     */
    @XmlPattern("^coupon_refund_\\d+$")
    private List<String> couponRefundList;

    /**
     * 退款代金券ID
     */
    @XmlPattern("^coupon_refund_id_\\d+$")
    private List<String> couponRefundIdList;

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

    public String getOutFefundNo() {
        return outFefundNo;
    }

    public void setOutFefundNo(String outFefundNo) {
        this.outFefundNo = outFefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getSettlementFefundFee() {
        return settlementFefundFee;
    }

    public void setSettlementFefundFee(Integer settlementFefundFee) {
        this.settlementFefundFee = settlementFefundFee;
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

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCashFefundFee() {
        return cashFefundFee;
    }

    public void setCashFefundFee(String cashFefundFee) {
        this.cashFefundFee = cashFefundFee;
    }

    public String getCouponFefundFee() {
        return couponFefundFee;
    }

    public void setCouponFefundFee(String couponFefundFee) {
        this.couponFefundFee = couponFefundFee;
    }

    public String getCouponFefundCount() {
        return couponFefundCount;
    }

    public void setCouponFefundCount(String couponFefundCount) {
        this.couponFefundCount = couponFefundCount;
    }

    public List<String> getCouponTypeList() {
        return couponTypeList;
    }

    public void setCouponTypeList(List<String> couponTypeList) {
        this.couponTypeList = couponTypeList;
    }

    public List<String> getCouponRefundList() {
        return couponRefundList;
    }

    public void setCouponRefundList(List<String> couponRefundList) {
        this.couponRefundList = couponRefundList;
    }

    public List<String> getCouponRefundIdList() {
        return couponRefundIdList;
    }

    public void setCouponRefundIdList(List<String> couponRefundIdList) {
        this.couponRefundIdList = couponRefundIdList;
    }
}
