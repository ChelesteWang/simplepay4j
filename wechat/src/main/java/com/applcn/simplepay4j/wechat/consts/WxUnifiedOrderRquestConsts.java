package com.applcn.simplepay4j.wechat.consts;

/**
 * 微信统一下单请求参数常量
 * @author dayaoguai
 */
public class WxUnifiedOrderRquestConsts extends CommonRequestConsts {

    /**
     * 设备号
     */
    public static final String DEVICE_INFO = "device_info";


    /**
     * 商品描述
     */
    public static final String BODY = "body";

    /**
     * 商品详情
     */
    public static final String DETAIL = "detail";

    /**
     * 附加数据
     */
    public static final String ATTACH = "attach";


    /**
     * 标价币种
     */
    public static final String FEE_TYPE = "fee_type";

    /**
     * 标价金额
     */
    public static final String TOTAL_FEE = "total_fee";

    /**
     * 终端IP
     */
    public static final String SPBILL_CREATE_IP = "spbill_create_ip";

    /**
     * 交易起始时间
     */
    public static final String TIME_START = "time_start";

    /**
     * 交易结束时间
     */
    public static final String TIME_EXPIRE = "time_expire";

    /**
     * 订单优惠标记
     */
    public static final String GOODS_TAG = "goods_tag";

    /**
     * 通知地址
     */
    public static final String NOTIFY_URL = "notify_url";

    /**
     * 交易类型
     */
    public static final String TRADE_TYPE = "trade_type";

    /**
     * 商品ID
     */
    public static final String PRODUCT_ID = "product_id";

    /**
     * 指定支付方式
     */
    public static final String LIMIT_PAY = "limit_pay";

    /**
     * 用户标识
     */
    public static final String OPENID = "openid";

    /**
     * 电子发票入口开放标识
     */
    public static final String RECEIPT = "receipt";

    /**
     * 场景信息
     */
    public static final String SCENE_INFO = "scene_info";
}

