### 项目简介
simplepay4j是一个集成支付工具的java拓展包，目前只集成了微信支付基本功能

oschina地址：https://github.com/YaoguaiDa/simplepay4j.git
github地址：https://github.com/YaoguaiDa/simplepay4j.git

* 为什么要重复造轮子？  
——年假在家闲呐！
### 项目特点
* 少依赖：除了yaml解析工具之外所有工具使用原生java开发，项目体积小
* 使用方便：隐藏了开发中繁琐的细节
* 易拓展：开发者可以根据需求灵活拓展自己的支付工具
* 容易理解：有完整的注释，以后也会有完善的使用文档和demo
* 模块化：可以按需引入需要的支付功能

### 使用方法
* 引入项目
    * 使用最新版：不知道为什么，maven中央仓库失效了，该方法失效，后续会修好
        * 下载项目到本地
        * 将项目导入到ide
        * 在根目录运行命令: mvn clean install
        * 在自己的项目pom.xml文件<dependencies></dependencies>节点下加入
    ```xml
     <dependency>
        <groupId>com.applcn</groupId>
        <artifactId>simplePay4j-wechat</artifactId>
        <version>1.0.0-alpha</version>
     </dependency>
    ```
        * 刷新maven
* 简单使用
    * jsapi/jssdk/微信小程序支付：
    ```java
      WxAccountModel accountModel = new WxAccountModel("公众号appid/小程序appid","微信商户号", "商户秘钥");
      MethodProxy proxy = Wechat.orderMethod(accountModel);
      WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("商品描述","商户订单号","商品价格，单位为分",
              "客户端ip", "回调地址", TradeTypeEnum.JSAPI);

      unifiedOrderModel.expand("发起支付的用户openid");
      WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);
      
      /**
       * 直接调用getPayResult处理好的数据转成json给前端
       */
      System.out.println(result.getPayResult());
    ```
    * native(扫码支付)支付：
    ```java
      WxAccountModel accountModel = new WxAccountModel("公众号appid/小程序appid","微信商户号", "商户秘钥");
      MethodProxy proxy = Wechat.orderMethod(accountModel);
      WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("商品描述","商户订单号","商品价格，单位为分",
          "客户端ip", "回调地址", TradeTypeEnum.NATIVE);
      
      unifiedOrderModel.expand("发起支付的用户openid");
      WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);
    
      /**
       * 此时result中codeUrl一定存在
       * 使用者可将codeUrl返回给前端，由前端生成二码，用户用微信扫描此二维码即可调起支付
       */
      System.out.println(result.getCodeUrl());
    ```
    
    * app支付:
    ```java
      WxAccountModel accountModel = new WxAccountModel("公众号appid/小程序appid","微信商户号", "商户秘钥");
      MethodProxy proxy = Wechat.orderMethod(accountModel);
      WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("商品描述","商户订单号","商品价格，单位为分",
          "客户端ip", "回调地址", TradeTypeEnum.APP);
        
      unifiedOrderModel.expand("发起支付的用户openid");
      WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);
      
      /**
       * 直接调用getPayResult处理好的数据转成json给前端
       */
      System.out.println(result.getPayResult());
    ```
    
    * h5支付：
    ```java
      WxAccountModel accountModel = new WxAccountModel("公众号appid/小程序appid","微信商户号", "商户秘钥");
      MethodProxy proxy = Wechat.orderMethod(accountModel);
      WxUnifiedOrderModel unifiedOrderModel = new WxUnifiedOrderModel("商品描述","商户订单号","商品价格，单位为分",
          "客户端ip", "回调地址", TradeTypeEnum.MWEB);
          
      unifiedOrderModel.expand("发起支付的用户openid");
      WxUnifiedOrderResponse result = (WxUnifiedOrderResponse) proxy.unifiedOrder(unifiedOrderModel);
      
      /**
       * 此时result中mwebUrl一定存在
       * mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
       * 开发者可直接将mwebUrl传给前端
       */
      System.out.println(result.getMwebUrl());
    ```
    
    * 提交付款码支付：
    ```java
      /**
       * appid：微信分配的公众账号ID（企业号corpid即为此appId）
       * mchId：商户号
       * key：商户平台秘钥
       */
      WxAccountModel accountModel = new WxAccountModel("公众号appid/小程序appid","微信商户号", "商户秘钥");
  
      MethodProxy proxy = Wechat.orderMethod(accountModel);
  
      /**
       * 付款码支付需要使用WxMicropayModel
       *
       */
      WxMicropayModel model = new WxMicropayModel("商品描述","商户订单号","商品价格，单位为分",
              "客户端ip", "用户付款码");
  
      WxMicropayResponse result = (WxMicropayResponse) proxy.micropay(model);
  
      /**
       * 若不抛异常返回结果内就有内容，开发者可以根据result的内容处理自己的逻辑
       */
      System.out.println(result);
    ```

    * 处理支付结果通知回调：
    ```java
      /**
       *inputStream: 即：java.io.InputStream，为前端出来的数据流
       */
      NotifyManageProxy proxy = Wechat.notifyManage(inputStream, "商户秘钥");
      WxOrderModel model = (WxOrderModel) proxy.manage();
      if(model != null){
        // TODO 处理用户自己的业务逻辑,如对比订单号，对比金额
      }else{
        // TODO 此处为签名错误返回信息构造可自行按照微信官方文档来写
        Map<String,String> error = new HashMap<>(2);
        error.put("return_code", "FAIL");
        error.put("return_msg", "签名错误");
        return XmlUtil.mapToXml(error, true);
      }
    ```
    * 订单查询：
        待完成
    * 关闭订单：
        待完成
    * 申请退款：
        待完成
    
### 其它
* 项目demo在example/test/java/下，使用的是springboottest，亲测