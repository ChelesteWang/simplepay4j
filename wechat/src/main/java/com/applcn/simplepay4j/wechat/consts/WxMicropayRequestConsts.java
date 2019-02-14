package com.applcn.simplepay4j.wechat.consts;

/**
 * 微信提交付款码支付请求参数常量
 * @author dayaoguai
 */
public class WxMicropayRequestConsts extends CommonRequestConsts {

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
     * 订单金额
     */
    public static final String TOTAL_FEE = "total_fee";

    /**
     * 货币类型
     */
    public static final String FEE_TYPE = "fee_type";

    /**
     * 终端IP
     */
    public static final String SPBILL_CREATE_IP = "spbill_create_ip";

    /**
     * 订单优惠标记
     */
    public static final String GOODS_TAG = "goods_tag";

    /**
     * 指定支付方式
     */
    public static final String LIMIT_PAY = "limit_pay";

    /**
     * 交易起始时间
     */
    public static final String TIME_STAR = "time_start";

    /**
     * 交易结束时间
     */
    public static final String TIME_EXPIRE = "time_expire";

    /**
     * 电子发票入口开放标识
     */
    public static final String RECEIPT = "receipt";

    /**
     * 授权码
     */
    public static final String AUTH_CODE = "auth_code";

    /**
     * 场景信息
     */
    public static final String SCENE_INFO = "scene_info";
}
