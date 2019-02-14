package com.applcn.simplepay4j.core.proxy;

import com.applcn.simplepay4j.core.model.*;
import com.applcn.simplepay4j.core.result.*;

/**
 * 支付代理对象
 * @author dayaoguai
 */
public interface MethodProxy {

    /**
     * 初始化
     * @param accountModel
     */
    void init(AccountModel accountModel);

    /**
     * 统一下单
     * @return
     */
    UnifiedOrderResult unifiedOrder(UnifiedOrderModel unifiedOrderModel) throws Exception;

    /**
     * 订单查询
     * @param orderQueryModel
     * @return
     */
    QueryOrderResult orderQuery(OrderQueryModel orderQueryModel) throws Exception;

    /**
     * 关闭订单
     * @param closeOrderModel
     * @return
     */
    CloseOrderResult closeOrder(CloseOrderModel closeOrderModel) throws Exception;

    /**
     * 申请退款
     * @param refundModel
     * @return
     */
    RefundResult refund(RefundModel refundModel) throws Exception;

    /**
     * 查询退款
     * @param refundQueryModel
     * @return
     */
    RefundQueryResult refundquery(RefundQueryModel refundQueryModel) throws Exception;

    /**
     * 退款回调
     * @param refundNotifyModel
     * @return
     */
    RefundNotifyResult refundNotify(RefundNotifyModel refundNotifyModel) throws Exception;

    /**
     * 下载对账单
     * @param downloadbillModel
     * @return
     */
    DownloadbillResult downloadbill(DownloadbillModel downloadbillModel) throws Exception;

    /**
     * 下载资金账单
     * @param downloadfundflowModel
     * @return
     */
    DownloadfundflowResult downloadfundflow(DownloadfundflowModel downloadfundflowModel) throws Exception;

    /**
     * 提交付款码支付
     * @param micropayModel
     * @return
     */
    MicropayResult micropay(MicropayModel micropayModel) throws Exception;
}