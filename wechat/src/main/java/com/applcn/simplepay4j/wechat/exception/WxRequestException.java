package com.applcn.simplepay4j.wechat.exception;

/**
 * 微信支付自定义异常
 * @author dayaoguai
 */
public class WxRequestException extends Exception {

    private static final long serialVersionUID = 4610703451066089908L;

    /**
     * 返回状态码
     */
    private int code;

    public WxRequestException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
