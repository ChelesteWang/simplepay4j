package com.applcn.simplepay4j.wechat.enums;

/**
 * 加密方式枚举
 * @author dayaoguai
 */
public enum SignTypeEnum {

    /**
     * mdg加密
     */
    MD5("MD5"),

    /**
     * HMAC_SHA256加密
     */
    HMAC_SHA256("HMAC-SHA256");

    private String value;

    SignTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
