package response;

import com.applcn.core.annotation.XmlNode;
import com.applcn.core.result.CloseOrderResult;

/**
 * 微信关闭订单返回
 * @author dayaoguai
 */
public class WxCloseOrderResponse implements CloseOrderResult {

    private static final long serialVersionUID = -8380222703581194557L;

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
     * 随机字符串
     */
    @XmlNode("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @XmlNode("sign")
    private String sign;

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
}
