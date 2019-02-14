package com.applcn.simplepay4j.wechat.model;

import com.applcn.simplepay4j.core.model.DownloadfundflowModel;

/**
 * 微信下载资金账单
 * @author dayaoguai
 */
public class WxDownloadfundflowModel implements DownloadfundflowModel {

    /**
     * 资金账单日期
     */
    private String billDate;

    /**
     * 资金账户类型
     */
    private String accountType;

    /**
     * 压缩账单
     * 返回格式是否为.gzip的压缩包账单
     * true 以.gzip格式返回
     * false 以数据流返回
     */
    private boolean tarTypeIsZip;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isTarTypeIsZip() {
        return tarTypeIsZip;
    }

    public void setTarTypeIsZip(boolean tarTypeIsZip) {
        this.tarTypeIsZip = tarTypeIsZip;
    }
}
