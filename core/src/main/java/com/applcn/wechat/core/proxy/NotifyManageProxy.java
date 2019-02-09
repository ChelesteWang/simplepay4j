package com.applcn.wechat.core.proxy;

import com.applcn.wechat.core.model.OrderModel;

/**
 * 回调管理代理对象
 * @author dayaoguai
 */
public interface NotifyManageProxy {

    /**
     * 初始化
     * @param orderModel
     * @param key
     */
    void init(OrderModel orderModel, String key);

    /**
     * 处理回调
     * @return
     */
    OrderModel manage() throws Exception;
}