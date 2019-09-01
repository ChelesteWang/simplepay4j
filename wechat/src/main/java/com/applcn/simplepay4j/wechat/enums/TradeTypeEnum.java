package com.applcn.simplepay4j.wechat.enums;

/**
 * 交易类型枚举
 * @author dayaoguai
 */
public enum  TradeTypeEnum {

    /**
     * jsapi/jssdk/小程序支付
     */
    JSAPI("JSAPI"),

    /**
     * native(扫码)支付
     */
    NATIVE("NATIVE"),

    /**
     * app支付
     */
    APP("APP"),

    /**
     * h5支付
     */
    MWEB("MWEB");

    private String value;

    TradeTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
