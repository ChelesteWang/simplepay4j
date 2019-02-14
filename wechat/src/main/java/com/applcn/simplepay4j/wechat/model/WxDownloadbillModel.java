package com.applcn.simplepay4j.wechat.model;

import com.applcn.simplepay4j.core.model.DownloadbillModel;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;

/**
 * 微信下载对账单请求模型
 * @author dayyaoguai
 */
public class WxDownloadbillModel implements DownloadbillModel {

    /**
     * 签名类型
     */
    private SignTypeEnum signType;

    /**
     * 对账单日期
     * 下载对账单的日期，格式：20140603
     */
    private String billDate;

    /**
     * 账单类型
     * ALL，返回当日所有订单信息，默认值
     * SUCCESS，返回当日成功支付的订单
     * REFUND，返回当日退款订单
     * RECHARGE_REFUND，返回当日充值退款订单
     */
    private String billType;

    /**
     * 压缩账单
     * 返回格式是否为.gzip的压缩包账单
     * true 以.gzip格式返回
     * false 以数据流返回
     */
    private boolean tarTypeIsZip;

    public WxDownloadbillModel() {
    }

    public WxDownloadbillModel(String billDate, String billType) {
        this.billDate = billDate;
        this.billType = billType;
    }

    public void expand(SignTypeEnum signType){
        this.signType = signType;
    }

    public void expand(boolean tarTypeIsZip){
        this.tarTypeIsZip = tarTypeIsZip;
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
        this.signType = signType;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public boolean isTarTypeIsZip() {
        return tarTypeIsZip;
    }

    public void setTarTypeIsZip(boolean tarTypeIsZip) {
        this.tarTypeIsZip = tarTypeIsZip;
    }
}
