package com.applcn.simplepay4j.example;

import com.applcn.simplepay4j.core.proxy.MethodProxy;
import com.applcn.simplepay4j.wechat.Wechat;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;
import com.applcn.simplepay4j.wechat.enums.TradeTypeEnum;
import com.applcn.simplepay4j.wechat.model.WxAccountModel;
import com.applcn.simplepay4j.wechat.model.WxUnifiedOrderModel;
import com.applcn.simplepay4j.wechat.response.WxUnifiedOrderResponse;
import com.applcn.simplepay4j.wechat.util.SignUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 微信支付测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleApplicationTests {

	/**
	 * 小程序、公众号等appid
	 */
	private static final String appid = "wxb310d85d3269b8fc";

	/**
	 * 商户平台商户号
	 */
	private static final String mchId = "1484850852";

	/**
	 * 商户平台秘钥
	 */
	private static final String key = "SQTEVXSNC54ET44FRFN5EPHLYPEYHGYM";

	/**
	 * 付款用户的openid
	 */
	private static final String openid = "oc8mmwfe7n5lhe04fKKXNs3eEwmU";

	/**
	 * 付款设备的ip地址
	 */
	private static final String ip = "116.208.50.7";

	/**
	 * 支付回调地址
	 */
	private static final String notifyUrl = "http://www.baidu.com";

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
		 * 将参数取出，签名，然后可将@params转成json传给前端
		 */
		Map<String,String> params = new HashMap<>();
		params.put("appId", result.getAppid());
		params.put("timeStamp", String.valueOf(System.currentTimeMillis()));
		params.put("nonceStr", UUID.randomUUID().toString());
		params.put("package", "prepay_id=" + result.getPrepayId());
		params.put("signType", result.getSignType().getValue());

		String sign = SignUtil.sign(params, result.getKey(), result.getSignType());
		params.put("sign", sign);
		System.out.println(params);
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
		 * tradeType：为枚举类型，当支付方式为native(扫码支付)时固定传TradeTypeEnum.NATIVE
		 */
		WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("测试商品","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.NATIVE);

		/**
		 * 当支付方式为native(扫码支付)支付时必传商户商品id
		 * openid固定在方法的第一个参数，但是不是必传但是需要一个空字符串或者null进行占位，若此参数传了，那么该支付只能由openid代表的用户来支付
		 * 商户商品id此时必传，固定在方法的第二个参数
		 */
		unifiedOrderModel.expand("", "123456");

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);

		/**
		 * 此时result中codeUrl一定存在
		 * 使用者可将codeUrl返回给前端，由前端生成二码，用户用微信扫描此二维码即可调起支付
		 */
		System.out.println(result.getCodeUrl());
	}

	/**
	 * app支付
	 */
	@Test
	public void appPay() throws Exception{
		/**
		 * appid：微信开放平台审核通过的应用APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 必传参数
		 * body：商品描述 微信要求传应用市场上的APP名字-实际商品名称，如：天天爱消除-游戏充值
		 * outTradeNo：商户订单号
		 * totalFee：金额，单位为分
		 * spbillCreateIp：客户端ip
		 * notifyUrl：回调地址
		 * tradeType：为枚举类型，当支付方式为App支付时固定传TradeTypeEnum.APP
		 */
		WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("应用市场上的APP名字-实际商品名称","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.APP);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);


		/**
		 * 将参数取出，签名，然后可讲@params转成json传给前端
		 */
		Map<String,String> params = new HashMap<>();
		params.put("appId", result.getAppid());
		params.put("timeStamp", String.valueOf(System.currentTimeMillis()));
		params.put("nonceStr", UUID.randomUUID().toString());
		params.put("package", "prepay_id=" + result.getPrepayId());
		params.put("signType", result.getSignType().getValue());

		String sign = SignUtil.sign(params, result.getKey(), result.getSignType());
		params.put("sign", sign);
		System.out.println(params);
	}

	/**
	 * h5支付
	 */
	@Test
	public void h5Pay() throws Exception{
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 必传参数
		 * body：商品描述 微信要求传浏览器打开的网站主页title名 -商品概述，如：腾讯充值中心-QQ会员充值
		 * outTradeNo：商户订单号
		 * totalFee：金额，单位为分
		 * spbillCreateIp：客户端ip
		 * notifyUrl：回调地址
		 * tradeType：为枚举类型，当支付方式为App支付时固定传TradeTypeEnum.APP
		 */
		WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("应用市场上的APP名字-实际商品名称","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.MWEB);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);


		/**
		 * 此时result中mwebUrl一定存在
		 * mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
		 * 开发者可直接将mwebUrl传给前端
		 */
		System.out.println(result.getMwebUrl());
	}

}

