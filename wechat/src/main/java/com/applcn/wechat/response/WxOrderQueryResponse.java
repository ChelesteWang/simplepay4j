package com.applcn.wechat.response;

import com.applcn.example.annotation.Pattern;
import com.applcn.example.annotation.XmlNode;
import com.applcn.example.result.QueryOrderResult;

import java.util.List;

/**
 * 微信订单查询返回
 * @author dayaoguai
 */
public class WxOrderQueryResponse implements QueryOrderResult {

    private static final long serialVersionUID = -5130173056059325881L;

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
     * 设备号
     */
    @XmlNode("device_info")
    private String deviceInfo;

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
     * 用户标识
     */
    @XmlNode("openid")
    private String openid;

    /**
     * 是否关注公众账号
     */
    @XmlNode("isSubscribe")
    private String isSubscribe;

    /**
     * 交易类型
     */
    @XmlNode("trade_type")
    private String tradeType;

    /**
     * 交易状态
     */
    @XmlNode("trade_state")
    private String tradeState;

    /**
     * 付款银行
     */
    @XmlNode("bank_type")
    private String bankType;

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
     * 代金券金额
     */
    @XmlNode("coupon_fee")
    private Integer couponFee;

    /**
     * 代金券使用数量
     */
    @XmlNode("coupon_count")
    private Integer couponCount;

    /**
     * 微信支付订单号
     */
    @XmlNode("transaction_id")
    private String transactionId;

    /**
     * 商户订单号
     */
    @XmlNode("out_trade_no")
    private String outTradeNo;

    /**
     * 附加数据
     */
    @XmlNode("attach")
    private String attach;

    /**
     * 支付完成时间
     */
    @XmlNode("time_end")
    private String timeEnd;

    /**
     * 交易状态描述
     */
    @XmlNode("trade_state_desc")
    private String tradeStateDesc;

    /**
     * 代金券类型
     */
    @Pattern("/^coupon_type_\\d+$/")
    private List<String> couponTypeList;

    /**
     * 代金券ID
     */
    @Pattern("/^coupon_id_\\d+$/")
    private List<String> couponIdList;

    /**
     * 单个代金券支付金额
     */
    @Pattern("/^coupon_fee_\\d+$/")
    private List<String> couponFeeList;

//    public static void main(String[] args){
//        String str = "coupon_fee_2";
//        String reg = "^coupon_fee_\\d+$";
//        boolean isMatch = Pattern.matches(reg, str);
//        System.out.println(isMatch);
//    }

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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
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

    public Integer getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }

    public List<String> getCouponTypeList() {
        return couponTypeList;
    }

    public void setCouponTypeList(List<String> couponTypeList) {
        this.couponTypeList = couponTypeList;
    }

    public List<String> getCouponIdList() {
        return couponIdList;
    }

    public void setCouponIdList(List<String> couponIdList) {
        this.couponIdList = couponIdList;
    }

    public List<String> getCouponFeeList() {
        return couponFeeList;
    }

    public void setCouponFeeList(List<String> couponFeeList) {
        this.couponFeeList = couponFeeList;
    }
}
