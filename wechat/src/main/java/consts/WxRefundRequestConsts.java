package consts;

/**
 * 微信申请退款请求参数常量
 * @author dayaoguai
 */
public class WxRefundRequestConsts extends CommonRequestConsts {

    /**
     * 微信订单号
     */
    public static final String TRANSACTION_ID = "transaction_id";

    /**
     * 商户退款单号
     */
    public static final String OUT_REFUND_NO = "out_refund_no";

    /**
     * 订单金额
     */
    public static final String TOTAL_FEE = "total_fee";

    /**
     * 退款金额
     */
    public static final String REFUND_FEE = "refund_fee";

    /**
     * 货币种类
     */
    public static final String REFUND_FEE_TYPE = "refund_fee_type";

    /**
     * 退款原因
     */
    public static final String REFUND_DESC = "refund_desc";

    /**
     * 退款资金来源
     */
    public static final String REFUND_ACCOUNT = "refund_account";

    /**
     * 退款结果通知url
     */
    public static final String NOTIFY_URL = "notify_url";
}
