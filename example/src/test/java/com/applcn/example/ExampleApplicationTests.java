package com.applcn.example;

import com.applcn.example.proxy.MethodProxy;
import com.applcn.wechat.Wechat;
import com.applcn.wechat.enums.TradeTypeEnum;
import com.applcn.wechat.model.WxAccountModel;
import com.applcn.wechat.model.WxUnifiedOrderModel;
import com.applcn.wechat.response.WxUnifiedOrderResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * 微信支付测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleApplicationTests {

	/**
	 * 小程序、公众号等appid
	 */
	private static final String appid = "";

	/**
	 * 商户平台商户号
	 */
	private static final String mchId = "";

	/**
	 * 商户平台秘钥
	 */
	private static final String key = "";

	/**
	 * 付款用户的openid
	 */
	private static final String openid = "";

	/**
	 * 付款设备的ip地址
	 */
	private static final String ip = "";

	/**
	 * 支付回调地址
	 */
	private static final String notifyUrl = "";

	/**
	 * jsapi/jssdk/微信小程序支付demo
	 * @throws Exception
	 */
	@Test
	public void jsapiUnifiedOrder() throws Exception {

		/**
		 * appid：小程序、公众号等appid
		 * mchId：商户平台商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 必传参数
		 * body：商品描述
		 * outTradeNo：商户订单号
		 * totalFee：金额，单位为分
		 * spbillCreateIp：客户端ip
		 * notifyUrl：回调地址
		 * tradeType：为枚举类型，当支付方式为jsapi/jssdk/微信小程序支付时固定传TradeTypeEnum.JSAPI
		 */
		WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("测试商品","wxtest11111",10,
				ip,notifyUrl, TradeTypeEnum.JSAPI);


		/**
		 * 当支付方式为jsapi/jssdk/微信小程序支付时必传支付用户的openid
		 * openid固定在方法的第一个参数
		 */
		unifiedOrderModel.expand(openid);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);

		/**
		 * 返回结果已处理，使用者可直接将返回结果result转成json返回给前端
		 */
		System.out.println(result);
	}

	/**
	 * native(扫码支付)支付demo
	 * @throws Exception
	 */
	@Test
	public void nativePay() throws Exception {

		/**
		 * appid：小程序、公众号等appid
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 必传参数
		 * body：商品描述
		 * outTradeNo：商户订单号
		 * totalFee：金额，单位为分
		 * spbillCreateIp：客户端ip
		 * notifyUrl：回调地址
		 * tradeType：为枚举类型，当支付方式为jsapi/jssdk/微信小程序支付时固定传TradeTypeEnum.JSAPI
		 */
		WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("测试商品","wxtest11114",10,
				"116.208.50.7","", TradeTypeEnum.NATIVE);

		/**
		 * 当支付方式为jnative(扫码支付)支付时必传用户openid和商户商品id
		 * openid固定在方法的第一个参数
		 * 商户商品id此时比船，固定在方法的第二个参数
		 */
		unifiedOrderModel.expand(openid, "123456");

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);

		/**
		 * 此时result中codeUrl一定存在
		 * 使用者可将codeUrl返回给前端，由前端生成二维码，用户用微信扫描此二维码即可调起支付
		 */
		System.out.println(result.getCodeUrl());
	}

}

