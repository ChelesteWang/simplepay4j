package com.applcn.simplepay4j.wechat.method;

import com.applcn.simplepay4j.core.model.*;
import com.applcn.simplepay4j.wechat.config.UrlConfig;
import com.applcn.simplepay4j.wechat.consts.*;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;
import com.applcn.simplepay4j.wechat.enums.TradeTypeEnum;
import com.applcn.simplepay4j.wechat.enums.WxReturnCodeEnum;
import com.applcn.simplepay4j.wechat.exception.WxParamException;
import com.applcn.simplepay4j.wechat.model.*;
import com.applcn.simplepay4j.wechat.response.*;
import com.applcn.simplepay4j.wechat.util.HttpUtil;
import com.applcn.simplepay4j.wechat.util.SignUtil;
import com.applcn.simplepay4j.core.proxy.MethodProxy;
import com.applcn.simplepay4j.core.utils.StringUtil;
import com.applcn.simplepay4j.core.utils.XmlUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * 微信支付
 * @author dayaoguai
 */
public class WxMethodRequest implements MethodProxy {

    private WxAccountModel accountModel;

    @Override
    public void init(AccountModel accountModel) {
       this.accountModel = (WxAccountModel) accountModel;
    }

    @Override
    public WxUnifiedOrderResponse unifiedOrder(UnifiedOrderModel unifiedOrderModel) throws Exception {
        WxUnifiedOrderModel unifiedOrder = (WxUnifiedOrderModel) unifiedOrderModel;

        Field[] fields = unifiedOrder.getClass().getDeclaredFields();
        Map<String, String> params = new HashMap<>(fields.length);
        TradeTypeEnum tradeType = unifiedOrder.getTradeType();
        SignTypeEnum signType = unifiedOrder.getSignType();

        params.put(WxUnifiedOrderRquestConsts.APP_ID, accountModel.getAppid());
        params.put(WxUnifiedOrderRquestConsts.MCH_ID, accountModel.getMchId());
        params.put(WxUnifiedOrderRquestConsts.NONCE_STR, UUID.randomUUID().toString().replace("-",""));
        params.put(WxUnifiedOrderRquestConsts.OUT_TRADE_NO, unifiedOrder.getOutTradeNo());
        params.put(WxUnifiedOrderRquestConsts.BODY, unifiedOrder.getBody());
        params.put(WxUnifiedOrderRquestConsts.TOTAL_FEE, unifiedOrder.getTotalFee()+"");
        params.put(WxUnifiedOrderRquestConsts.SPBILL_CREATE_IP, unifiedOrder.getSpbillCreateIp());
        params.put(WxUnifiedOrderRquestConsts.NOTIFY_URL, unifiedOrder.getNotifyUrl());
        params.put(WxUnifiedOrderRquestConsts.DEVICE_INFO,unifiedOrder.getDeviceInfo());
        params.put(WxUnifiedOrderRquestConsts.DETAIL,unifiedOrder.getDetail());
        params.put(WxUnifiedOrderRquestConsts.ATTACH,unifiedOrder.getAttach());
        params.put(WxUnifiedOrderRquestConsts.FEE_TYPE,unifiedOrder.getFeeType());
        params.put(WxUnifiedOrderRquestConsts.TIME_START,unifiedOrder.getTimeStart());
        params.put(WxUnifiedOrderRquestConsts.TIME_EXPIRE,unifiedOrder.getTimeExpire());
        params.put(WxUnifiedOrderRquestConsts.GOODS_TAG,unifiedOrder.getGoodsTag());
        params.put(WxUnifiedOrderRquestConsts.PRODUCT_ID,unifiedOrder.getProductId());
        params.put(WxUnifiedOrderRquestConsts.OPENID,unifiedOrder.getOpenid());
        params.put(WxUnifiedOrderRquestConsts.LIMIT_PAY,unifiedOrder.getLimitPay());
        params.put(WxUnifiedOrderRquestConsts.RECEIPT,unifiedOrder.getReceipt());
        params.put(WxUnifiedOrderRquestConsts.SCENE_INFO,unifiedOrder.getSceneInfo());

        if(tradeType != null){
            params.put(WxUnifiedOrderRquestConsts.TRADE_TYPE, tradeType.getValue());
            if(TradeTypeEnum.JSAPI == tradeType){
                if(StringUtil.isEmpty(unifiedOrder.getOpenid())){
                    throw new WxParamException("当trade_type=JSAPI时,用户标识不能为空");
                }
            }else if (TradeTypeEnum.NATIVE == tradeType){
                if(StringUtil.isEmpty(unifiedOrder.getProductId())){
                    throw new WxParamException("当trade_type=NATIVE时,商品id不能为空");
                }
            }

        }

        params.put(WxUnifiedOrderRquestConsts.SIGN, SignUtil.sign(params, accountModel.getKey(), signType));

        String xml = XmlUtil.mapToXml(params, true);

        String responseXml = HttpUtil.post(UrlConfig.getInstance().getUnifiedOrder(), xml);

        WxUnifiedOrderResponse response = XmlUtil.xmlToPojo(responseXml, WxUnifiedOrderResponse.class);

        if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getReturnCode())){
            if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getResultCode())){
                response.setKey(accountModel.getKey());
                response.setSignType(unifiedOrder.getSignType());
                return response;
            }else{
                throw new WxParamException(response.getErrCodeDes());
            }
        }else{
            throw new WxParamException(response.getReturnMsg());
        }
    }

    @Override
    public WxOrderQueryResponse orderQuery(OrderQueryModel orderQueryModel) throws Exception {
        WxOrderQueryModel orderQuery = (WxOrderQueryModel) orderQueryModel;

        Field[] fields = orderQuery.getClass().getDeclaredFields();
        Map<String, String> params = new HashMap<>(fields.length);
        SignTypeEnum signType = orderQuery.getSignType();
        params.put(WxOrderQueryRequestConsts.APP_ID, accountModel.getAppid());
        params.put(WxOrderQueryRequestConsts.MCH_ID, accountModel.getMchId());
        params.put(WxOrderQueryRequestConsts.NONCE_STR, UUID.randomUUID().toString().replace("-",""));
        if(StringUtil.isEmpty(orderQuery.getTransactionId()) && StringUtil.isEmpty(orderQuery.getOutTradeNo())){
            throw new WxParamException("微信订单号或者商户订单号不能为空");
        }

        if(!StringUtil.isEmpty(orderQuery.getTransactionId())){
            params.put(WxOrderQueryRequestConsts.TRANSACTION_ID, orderQuery.getTransactionId());
        }

        if(!StringUtil.isEmpty(orderQuery.getOutTradeNo())){
            params.put(WxOrderQueryRequestConsts.OUT_TRADE_NO, orderQuery.getOutTradeNo());
        }

        params.put(WxOrderQueryRequestConsts.SIGN, SignUtil.sign(params, accountModel.getKey(), signType));

        String xml = XmlUtil.mapToXml(params, true);

        String responseXml = HttpUtil.post(UrlConfig.getInstance().getOrderQuery(), xml);

        WxOrderQueryResponse response = XmlUtil.xmlToPojo(responseXml, WxOrderQueryResponse.class);

        if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getReturnCode())){
            if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getResultCode())){
                return response;
            }else{
                throw new WxParamException(response.getErrCodeDes());
            }
        }else{
            throw new WxParamException(response.getReturnMsg());
        }
    }

    @Override
    public WxCloseOrderResponse closeOrder(CloseOrderModel closeOrderModel) throws Exception {
        WxCloseOrderModel closeOrder = (WxCloseOrderModel) closeOrderModel;

        Field[] fields = closeOrder.getClass().getDeclaredFields();
        Map<String, String> params = new HashMap<>(fields.length);
        SignTypeEnum signType = closeOrder.getSignType();
        params.put(WxCloseOrderRequestConsts.APP_ID, accountModel.getAppid());
        params.put(WxCloseOrderRequestConsts.MCH_ID, accountModel.getMchId());
        params.put(WxCloseOrderRequestConsts.OUT_TRADE_NO, closeOrder.getOutTradeNo());
        params.put(WxCloseOrderRequestConsts.NONCE_STR, UUID.randomUUID().toString().replace("-", ""));

        params.put(WxOrderQueryRequestConsts.SIGN, SignUtil.sign(params, accountModel.getKey(), signType));

        String xml = XmlUtil.mapToXml(params, true);

        String resultXml = HttpUtil.post(UrlConfig.getInstance().getCloseOrder(), xml);

        WxCloseOrderResponse response = XmlUtil.xmlToPojo(resultXml, WxCloseOrderResponse.class);

        if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getReturnCode())){
            if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getResultCode())){
                return response;
            }else{
                throw new WxParamException(response.getResultCode());
            }
        }else{
            throw new WxParamException(response.getReturnMsg());
        }
    }

    @Override
    public WxRefundResponse refund(RefundModel refundModel) throws Exception {
        WxRefundModel wxRefundModel = (WxRefundModel) refundModel;

        Field[] fields = refundModel.getClass().getDeclaredFields();
        Map<String, String> params = new HashMap<>(fields.length);
        SignTypeEnum signType = wxRefundModel.getSignType();
        params.put(WxRefundRequestConsts.APP_ID, accountModel.getAppid());
        params.put(WxRefundRequestConsts.MCH_ID, accountModel.getMchId());
        params.put(WxRefundRequestConsts.NONCE_STR, UUID.randomUUID().toString().replace("-", ""));
        params.put(WxRefundRequestConsts.OUT_TRADE_NO, wxRefundModel.getOutTradeNo());
        params.put(WxRefundRequestConsts.SIGN_TYPE, signType.getValue());
        params.put(WxRefundRequestConsts.TRANSACTION_ID, wxRefundModel.getTransactionId());
        params.put(WxRefundRequestConsts.OUT_TRADE_NO, wxRefundModel.getOutTradeNo());
        params.put(WxRefundRequestConsts.OUT_REFUND_NO, wxRefundModel.getOutRefundNo());
        params.put(WxRefundRequestConsts.TOTAL_FEE, wxRefundModel.getTotalFee().toString());
        params.put(WxRefundRequestConsts.REFUND_FEE, wxRefundModel.getRefundFee().toString());
        params.put(WxRefundRequestConsts.REFUND_FEE_TYPE, wxRefundModel.getRefundFeeType());
        params.put(WxRefundRequestConsts.REFUND_DESC, wxRefundModel.getRefundDesc());
        params.put(WxRefundRequestConsts.REFUND_ACCOUNT, wxRefundModel.getRefundAccount());
        params.put(WxRefundRequestConsts.NOTIFY_URL, wxRefundModel.getNotifyUrl());

        params.put(WxRefundRequestConsts.SIGN, SignUtil.sign(params, accountModel.getKey(), signType));

        String xml = XmlUtil.mapToXml(params, true);

        String resultXml = HttpUtil.post(UrlConfig.getInstance().getCloseOrder(), xml);

        WxRefundResponse response = XmlUtil.xmlToPojo(resultXml, WxRefundResponse.class);
        if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getReturnCode())){
            if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getResultCode())){
                return response;
            }else{
                throw new WxParamException(response.getResultCode());
            }
        }else{
            throw new WxParamException(response.getReturnMsg());
        }
    }

    @Override
    public WxRefundQueryResponse refundquery(RefundQueryModel refundQueryModel) throws Exception {
        WxRefundQueryModel wxRefundQueryModel = (WxRefundQueryModel) refundQueryModel;

        Field[] fields = wxRefundQueryModel.getClass().getDeclaredFields();
        Map<String, String> params = new HashMap<>(fields.length);
        SignTypeEnum signType = wxRefundQueryModel.getSignType();
        params.put(WxRefundQueryRequestConsts.APP_ID, accountModel.getAppid());
        params.put(WxRefundQueryRequestConsts.MCH_ID, accountModel.getMchId());
        params.put(WxRefundQueryRequestConsts.NONCE_STR, UUID.randomUUID().toString().replace("-", ""));
        params.put(WxRefundQueryRequestConsts.SIGN_TYPE, signType.getValue());
        params.put(WxRefundQueryRequestConsts.TRANSACTION_ID, wxRefundQueryModel.getTransactionId());
        params.put(WxRefundQueryRequestConsts.OUT_TRADE_NO, wxRefundQueryModel.getOutTradeNo());
        params.put(WxRefundQueryRequestConsts.OUT_REFUND_NO, wxRefundQueryModel.getOutRefundNo());
        params.put(WxRefundQueryRequestConsts.REFUND_ID, wxRefundQueryModel.getRefundId());
        params.put(WxRefundQueryRequestConsts.OFFSET, wxRefundQueryModel.getOffset());

        params.put(WxRefundQueryRequestConsts.SIGN, SignUtil.sign(params, accountModel.getKey(), signType));

        String xml = XmlUtil.mapToXml(params, true);

        String resultXml = HttpUtil.post(UrlConfig.getInstance().getCloseOrder(), xml);
        WxRefundQueryResponse response = XmlUtil.xmlToPojo(resultXml, WxRefundQueryResponse.class);
        if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getReturnCode())){
            if(WxReturnCodeEnum.SUCCESS.getValue().equals(response.getResultCode())){
                return response;
            }else{
                throw new WxParamException(response.getResultCode());
            }
        }else{
            throw new WxParamException(response.getReturnMsg());
        }
    }
}
