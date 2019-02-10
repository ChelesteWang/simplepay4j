package com.applcn.wechat.config;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 请求地址配置
 * @author dayaoguai
 */
public class UrlConfig {

    /**
     * 统一下单
     */
    private String unifiedOrder;

    /**
     * 查询订单
     */
    private String orderQuery;

    /**
     * 关闭订单
     */
    private String closeOrder;

    /**
     * 申请退款
     */
    private String refund;

    /**
     * 查询退款
     */
    private String refundQuery;

    /**
     * 下载对账单
     */
    private String downloadBill;

    /**
     * 下载资金账单
     */
    private String downloadFundFlow;

    private static volatile UrlConfig instance;

    private UrlConfig() {
    }

    public static UrlConfig getInstance() throws FileNotFoundException {
        String path = UrlConfig.class.getClassLoader().getResource("config/urlConfig.yml").getPath();
        if (instance == null) {
            synchronized (UrlConfig.class) {
                if (instance == null) {
                    Yaml yaml = new Yaml();
                    instance = yaml.loadAs(new FileInputStream(
                                    new File(path)),
                            UrlConfig.class);
                }
            }
        }
        return instance;
    }
    public String getUnifiedOrder() {
        return unifiedOrder;
    }

    public void setUnifiedOrder(String unifiedOrder) {
        this.unifiedOrder = unifiedOrder;
    }

    public String getOrderQuery() {
        return orderQuery;
    }

    public void setOrderQuery(String orderQuery) {
        this.orderQuery = orderQuery;
    }

    public String getCloseOrder() {
        return closeOrder;
    }

    public void setCloseOrder(String closeOrder) {
        this.closeOrder = closeOrder;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getRefundQuery() {
        return refundQuery;
    }

    public void setRefundQuery(String refundQuery) {
        this.refundQuery = refundQuery;
    }

    public String getDownloadBill() {
        return downloadBill;
    }

    public void setDownloadBill(String downloadBill) {
        this.downloadBill = downloadBill;
    }

    public String getDownloadFundFlow() {
        return downloadFundFlow;
    }

    public void setDownloadFundFlow(String downloadFundFlow) {
        this.downloadFundFlow = downloadFundFlow;
    }
}
