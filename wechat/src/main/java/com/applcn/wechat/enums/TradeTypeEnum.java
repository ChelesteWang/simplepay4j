package com.applcn.wechat.enums;

/**
 * 交易类型枚举
 * @author dayaoguai
 */
public enum  TradeTypeEnum {
    JSAPI("JSAPI"),
    NATIVE("NATIVE"),
    APP("APP"),
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
