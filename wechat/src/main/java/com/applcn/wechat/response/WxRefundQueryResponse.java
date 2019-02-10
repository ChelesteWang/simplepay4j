package com.applcn.wechat.response;

import com.applcn.example.annotation.XmlNode;
import com.applcn.example.result.RefundQueryResult;

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
}
