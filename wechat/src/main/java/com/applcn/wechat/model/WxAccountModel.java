package com.applcn.wechat.model;

import com.applcn.example.model.AccountModel;
import com.applcn.example.proxy.MethodProxy;
import com.applcn.wechat.method.WxMethodRequest;

/**
 * 微信账号信息
 * @author dayaoguai
 */
public class WxAccountModel implements AccountModel {

    /**
     * 小程序ID
     * 微信分配的小程序ID
     * 必填
     */
    private String appid;

    /**
     * 商户号
     * 微信支付分配的商户号
     * 必填
     */
    private String mchId;

    /**
     * 支付秘钥
     */
    private String key;

    public WxAccountModel() {
    }

    public WxAccountModel(String appid, String mchId, String key) {
        this.appid = appid;
        this.mchId = mchId;
        this.key = key;
    }

    @Override
    public MethodProxy init() {
        return new WxMethodRequest();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}