package com.applcn.core.proxy;

import com.applcn.core.model.AccountModel;
import com.applcn.core.model.CloseOrderModel;
import com.applcn.core.model.OrderQueryModel;
import com.applcn.core.model.UnifiedOrderModel;
import com.applcn.core.result.CloseOrderResult;
import com.applcn.core.result.QueryOrderResult;
import com.applcn.core.result.UnifiedOrderResult;

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
}