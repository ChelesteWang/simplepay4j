package response;

import com.applcn.core.annotation.XmlNode;
import com.applcn.core.result.UnifiedOrderResult;
import enums.SignTypeEnum;
import enums.TradeTypeEnum;
import util.SignUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 微信统一下单返回
 * @author dayaoguai
 */
public class WxUnifiedOrderResponse implements UnifiedOrderResult {

    private static final long serialVersionUID = 7716495302416334552L;

    /**
     * 返回状态码
     */
    @XmlNode("return_code")
    private String returnCode;

    /**
     * 返回信息
     */
    @XmlNode("return_msg")
    private String returnMsg;

    /**
     * 业务结果
     */
    @XmlNode("result_code")
    private String resultCode;

    /**
     * 错误代码
     */
    @XmlNode("err_code")
    private String errCode;

    /**
     * 错误代码描述
     */
    @XmlNode("err_code_des")
    private String errCodeDes;

    /**
     * 小程序ID
     */
    @XmlNode("appid")
    private String appid;

    /**
     * 商户号
     */
    @XmlNode("mch_id")
    private String mchId;

    /**
     * 设备号
     */
    @XmlNode("device_info")
    private String deviceInfo;

    /**
     * 随机字符串
     */
    @XmlNode("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XmlNode("sign")
    private String sign;

    /**
     * 交易类型
     */
    @XmlNode("trade_type")
    private String tradeType;

    /**
     * 预支付交易会话标识
     */
    @XmlNode("prepay_id")
    private String prepayId;

    /**
     * 二维码链接
     */
    @XmlNode("code_url")
    private String codeUrl;

    /**
     * 商户秘钥
     */
    private String key;

    /**
     * 签名类型
     */
    private SignTypeEnum signType;

    public Map<String, String> getPayResult() throws Exception {
        Map<String,String> responseMap = new HashMap<>(5);
        if(TradeTypeEnum.NATIVE.equals(tradeType)){
            responseMap.put("codeUrl", codeUrl);
        }else{
            responseMap.put("appId", appid);
            responseMap.put("timeStamp", System.currentTimeMillis()/1000+"");
            responseMap.put("nonceStr", UUID.randomUUID().toString().replace("-", ""));
            responseMap.put("package", String.format("prepay_id=%s",
                    prepayId));
            responseMap.put("signType", SignUtil.sign(responseMap, key, signType));
        }

        return responseMap;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SignTypeEnum getSignType() {
        return signType;
    }

    public void setSignType(SignTypeEnum signType) {
        this.signType = signType;
    }
}
