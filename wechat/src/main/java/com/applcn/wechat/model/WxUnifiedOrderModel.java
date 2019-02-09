package com.applcn.wechat.model;

import com.applcn.wechat.core.annotation.Exclude;
import com.applcn.wechat.core.model.UnifiedOrderModel;
import com.applcn.wechat.enums.SignTypeEnum;
import com.applcn.wechat.enums.TradeTypeEnum;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 微信支付统一下单
 * @author dayaoguai
 */
public class WxUnifiedOrderModel implements UnifiedOrderModel {

    /**
     * 用户标识
     * trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
     */

    private String openid;

    /**
     * 商品ID
     * trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
     */
    private String productId;

    /**
     * 签名类型
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     * 非必填
     */
    @Exclude
    private SignTypeEnum signType;

    /**
     * 设备号
     * 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
     * 非必填
     */
    private String deviceInfo;

    /**
     * 商品描述
     * 商品简单描述
     * 必填
     */
    @Exclude
    private String body;

    /**
     * 商品详情
     * 商品详细描述
     * 非必填
     */
    private String detail;

    /**
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
     * 非必填
     */
    private String attach;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一
     * 必填
     */
    @Exclude
    private String outTradeNo;

    /**
     * 标价币种
     * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
     * 非必填
     */
    private String feeType;

    /**
     * 标价金额
     * 订单总金额，单位为分
     * 必填
     */
    @Exclude
    private int totalFee;

    /**
     * 终端IP
     * 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     * 必填
     */
    @Exclude
    private String spbillCreateIp;

    /**
     * 交易起始时间
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
     * 非必填
     */
    private String timeStart;

    /**
     * 交易结束时间
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。
     * 订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，
     * 所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id
     * 非必填
     */
    private String timeExpire;

    /**
     * 订单优惠标记
     * 订单优惠标记，使用代金券或立减优惠功能时需要的参数
     * 非必填
     */
    private String goodsTag;

    /**
     * 通知地址
     * 步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数
     * 必填
     */
    @Exclude
    private String notifyUrl;

    /**
     * 交易类型
     * JSAPI--JSAPI支付（或小程序支付）
     * NATIVE--Native支付
     * APP--app支付
     * MWEB--H5支付
     * 不同trade_type决定了调起支付的方式
     * 必填
     */
    @Exclude
    private TradeTypeEnum tradeType;

    /**
     * 指定支付方式
     * 上传此参数no_credit--可限制用户不能使用信用卡支付
     */
    private String limitPay;

    /**
     * 电子发票入口开放标识
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。
     * 需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    private String receipt;

    /**
     * 场景信息
     * 该字段常用于线下活动时的场景信息上报，
     * 支持上报实际门店信息，
     * 商户也可以按需求自己上报相关信息。
     * 该字段为JSON对象数据，
     * 对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "门店行政区划码","address": "门店详细地址" }}
     */
    private String sceneInfo;

    public WxUnifiedOrderModel() {
    }

    public WxUnifiedOrderModel(String body, String outTradeNo, int totalFee,
                               String spbillCreateIp, String notifyUrl,
                               TradeTypeEnum tradeType) {
        this.body = body;
        this.outTradeNo = outTradeNo;
        this.totalFee = totalFee;
        this.spbillCreateIp = spbillCreateIp;
        this.notifyUrl = notifyUrl;
        this.tradeType = tradeType;
    }

    public void expand(SignTypeEnum signType){
        this.signType = signType;
    }

    /**
     * 拓展接口，用于传输非必填参数
     * params 参数顺序
     * openid 用户标识
     * productId 商品ID
     * deviceInfo 设备信息
     * detail 商品详情
     * attach 附加数据
     * feeType 标价币种
     * spbillCreateIp 终端IP
     * timeStart 开始时间
     * timeExpire 结束时间
     * goodsTag 订单优惠标记
     * limitPay 指定支付方式
     * receipt 电子发票入口开放标识
     * sceneInfo 场景信息
     * @param params
     */
    public void expand(String ... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Field[] fields = this.getClass().getDeclaredFields();
        int index = 0;
        for (Field item:fields) {
            if(!item.isAnnotationPresent(Exclude.class)){
                Method method;
                String className = item.getType().getName();
                String name = item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1);
                method = this.getClass().getMethod("set" + name, Class.forName(className));
                method.invoke(this, params[index]);
                if(index < params.length - 1){
                    index ++;
                }else{
                    break;
                }
            }
        }
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
        this.signType = signType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public TradeTypeEnum getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeTypeEnum tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
