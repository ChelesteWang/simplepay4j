package com.applcn.wechat.consts;

/**
 * 微信申请退款请求参数常量
 * @author dayaoguai
 */
public class WxRefundQueryRequestConsts extends CommonRequestConsts {

    /**
     * 微信订单号
     */
    public static final String TRANSACTION_ID = "transaction_id";

    /**
     * 商户退款单号
     */
    public static final String OUT_REFUND_NO = "out_refund_no";

    /**
     * 微信退款单号
     */
    public static final String REFUND_ID = "refund_id";

    /**
     * 偏移量
     */
    public static final String OFFSET = "offset";
}
