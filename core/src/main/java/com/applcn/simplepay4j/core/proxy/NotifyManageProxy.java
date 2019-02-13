package com.applcn.simplepay4j.core.proxy;

import com.applcn.simplepay4j.core.model.PayOrderModel;

/**
 * 回调管理代理对象
 * @author dayaoguai
 */
public interface NotifyManageProxy {

    /**
     * 初始化
     * @param payOrderModel
     * @param key
     */
    void init(PayOrderModel payOrderModel, String key);

    /**
     * 支付处理回调
     * @return
     */
    PayOrderModel manage() throws Exception;


}