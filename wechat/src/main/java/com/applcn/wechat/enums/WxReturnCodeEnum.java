package com.applcn.wechat.enums;

/**
 * 微信返回状态码枚举
 * @author dayaoguai
 */
public enum  WxReturnCodeEnum {
    SUCCESS("SUCCESS"),
    FAIL("FAIL");

    private String value;

    WxReturnCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
