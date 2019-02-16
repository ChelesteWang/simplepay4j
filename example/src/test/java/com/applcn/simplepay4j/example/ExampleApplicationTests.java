package com.applcn.simplepay4j.example;

import com.applcn.simplepay4j.core.model.CloseOrderModel;
import com.applcn.simplepay4j.core.model.DownloadbillModel;
import com.applcn.simplepay4j.core.model.PayOrderModel;
import com.applcn.simplepay4j.core.proxy.MethodProxy;
import com.applcn.simplepay4j.core.proxy.NotifyManageProxy;
import com.applcn.simplepay4j.wechat.Wechat;
import com.applcn.simplepay4j.wechat.enums.TradeTypeEnum;
import com.applcn.simplepay4j.wechat.model.*;
import com.applcn.simplepay4j.wechat.response.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
		WxUnifiedOrderModel model = new WxUnifiedOrderModel("测试商品","wxtest11111",10,
				ip,notifyUrl, TradeTypeEnum.JSAPI);


		/**
		 * 当支付方式为jsapi/jssdk/微信小程序支付时必传支付用户的openid
		 * openid固定在方法的第一个参数
		 */
		model.expand(openid);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(model);

		/**
		 * 直接调用getPayResult处理好的数据转成json给前端
		 */
		System.out.println(result.getPayResult());
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
		WxUnifiedOrderModel model = new WxUnifiedOrderModel("测试商品","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.NATIVE);

		/**
		 * 当支付方式为native(扫码支付)支付时必传商户商品id
		 * openid固定在方法的第一个参数，但是不是必传但是需要一个空字符串或者null进行占位，若此参数传了，那么该支付只能由openid代表的用户来支付
		 * 商户商品id此时必传，固定在方法的第二个参数
		 */
		model.expand("", "123456");

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(model);

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
		WxUnifiedOrderModel model = new WxUnifiedOrderModel("应用市场上的APP名字-实际商品名称","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.APP);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(model);


		/**
		 * 直接调用getPayResult处理好的数据转成json给前端
		 */
		System.out.println(result.getPayResult());
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
		WxUnifiedOrderModel model = new WxUnifiedOrderModel("应用市场上的APP名字-实际商品名称","wxtest11114",10,
				ip,notifyUrl, TradeTypeEnum.MWEB);

		WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(model);


		/**
		 * 此时result中mwebUrl一定存在
		 * mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
		 * 开发者可直接将mwebUrl传给前端
		 */
		System.out.println(result.getMwebUrl());
	}

	/**
	 * 付款码支付
	 */
	@Test
	public void microPay() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 付款码支付需要使用WxMicropayModel
		 *
		 */
		WxMicropayModel model = new WxMicropayModel("测试商品","wxtest11111",10,
				ip, "用户付款码");

		WxMicropayResponse result = (WxMicropayResponse) proxy.micropay(model);

		/**
		 * 若不抛异常返回结果内就有内容，开发者可以根据result的内容处理自己的逻辑
		 */
		System.out.println(result);

	}

	/**
	 * 支付回调管理
	 */
	@Test
	public void payNotify() throws Exception {
		/**
		 * in为微信传来的数据流
		 */
		InputStream in = new FileInputStream("");
		NotifyManageProxy proxy = Wechat.payNotifyManage(in, key);
		PayOrderModel model = proxy.manage();
		if(model != null){
			// TODO 处理用户自己的业务逻辑,如对比订单号，对比金额
		}else{
			// TODO 此处为签名错误返回信息构造可自行按照微信官方文档来写
			Map<String,String> error = new HashMap<>(2);
			error.put("return_code", "FAIL");
			error.put("return_msg", "签名错误");
		}
	}

	/**
	 * 退款回调管理
	 */
	@Test
	public void refundNotify() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		WxRefundNotifyModel model = new WxRefundNotifyModel();

		WxRefundNotifyResponse result = (WxRefundNotifyResponse) proxy.refundNotify(model);

		if(result != null){
			// TODO 处理用户自己的业务逻辑,如对比订单号，对比金额
		}else{
			// TODO 此处为签名错误返回信息构造可自行按照微信官方文档来写
			Map<String,String> error = new HashMap<>(2);
			error.put("return_code", "FAIL");
			error.put("return_msg", "签名错误");
		}
	}

	/**
	 * 订单查询
	 * @throws Exception
	 */
	@Test
	public void orderquery() throws Exception {
		/**
		 * appid：小程序、公众号等appid
		 * mchId：商户平台商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 默认使用微信订单号
		 * 若想使用商户订单号需要调用setOutTradeNo方法,此时微信订单号不传，否则会优先使用微信订单号
		 */
		WxOrderQueryModel model = new WxOrderQueryModel("微信订单号");

		/**
		 * 开发者可根据返回结果编写自己的逻辑
		 */
		WxOrderQueryResponse result = (WxOrderQueryResponse) proxy.orderQuery(model);

	}

	/**
	 * 关闭订单
	 */
	@Test
	public void closeOrder() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * outTradeNo为商户订单号，必填
		 */
		WxCloseOrderModel model = new WxCloseOrderModel("商户号");

		/**
		 * 开发者可根据返回的结果编写自己的逻辑
		 */
		WxCloseOrderResponse result = (WxCloseOrderResponse) proxy.closeOrder(model);

	}

	/**
	 * 申请退款
	 */
	@Test
	public void refund() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 必传参数
		 * transactionId：微信订单号
		 * outRefundNo：商户退款号
		 * totalFee：订单金额，单位分
		 * refundFee：退款金额，单位分
		 */
		WxRefundModel model = new WxRefundModel("微信订单号", "outRefundNo", 10, 10);

		/**
		 * 开发者可根据返回的结果编写自己的逻辑
		 */
		WxRefundResponse result = (WxRefundResponse) proxy.refund(model);
	}

	/**
	 * 查询退款
	 */
	@Test
	public void refundquery() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		/**
		 * 优先使用微信订单号
		 * 若需要用其它订单号直接调用set方法
		 */
		WxRefundQueryModel model = new WxRefundQueryModel("微信订单号");

		/**
		 * 开发者可根据返回的结果编写自己的逻辑
		 */
		WxRefundQueryResponse result = (WxRefundQueryResponse) proxy.refundquery(model);
	}

	/**
	 * 下载对账单
	 */
	@Test
	public void downloadbill() throws Exception{
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		WxDownloadbillModel model = new WxDownloadbillModel("20181104", "ALL");

		/**
		 * 设置是否下载.gzip的压缩包账单
		 * 若为true则返回.gzip的压缩包账单
		 * 若为false则返回字符串形式
		 * 不填默认false
		 */
		boolean tarTypeIsZip = true;
		model.expand(tarTypeIsZip);


		WxDownloadbillResponse result = (WxDownloadbillResponse) proxy.downloadbill(model);
		if (tarTypeIsZip){
			/**
			 * 当下载.gzip的压缩包账单时用InputStream获取
			 */
			System.out.println(result.getResultInputStream());
		}else{
			/**
			 * 当返回字符串形式时，取resultString
			 */
			System.out.println(result.getResultString());
		}
	}

	/**
	 * 下载资金账单
	 */
	@Test
	public void downloadfundflow() throws Exception {
		/**
		 * appid：微信分配的公众账号ID（企业号corpid即为此appId）
		 * mchId：商户号
		 * key：商户平台秘钥
		 */
		WxAccountModel accountModel = new WxAccountModel(appid,mchId, key);

		MethodProxy proxy = Wechat.orderMethod(accountModel);

		WxDownloadfundflowModel model = new WxDownloadfundflowModel("20181104", "Basic");

		/**
		 * 设置是否下载.gzip的压缩包账单
		 * 若为true则返回.gzip的压缩包账单
		 * 若为false则返回字符串形式
		 * 不填默认false
		 */
		boolean tarTypeIsZip = true;
		model.expand(tarTypeIsZip);

		WxDownloadfundflowResponse result = (WxDownloadfundflowResponse) proxy.downloadfundflow(model);
		if (tarTypeIsZip){
			/**
			 * 当下载.gzip的压缩包账单时用InputStream获取
			 */
			System.out.println(result.getResultInputStream());
		}else{
			/**
			 * 当返回字符串形式时，取resultString
			 */
			System.out.println(result.getResultString());
		}
	}
}

