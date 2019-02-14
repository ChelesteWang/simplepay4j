package com.applcn.simplepay4j.wechat.response;

import com.applcn.simplepay4j.core.annotation.XmlNode;
import com.applcn.simplepay4j.core.result.DownloadfundflowResult;

import java.io.InputStream;

/**
 * 微信下载资金账单返回结果
 * @author dayaoguai
 */
public class WxDownloadfundflowResponse implements DownloadfundflowResult {

    private static final long serialVersionUID = -668054107363115493L;

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
     * 错误代码描述
     */
    @XmlNode("err_code_des")
    private String errCodeDes;

    /**
     * 返回字符串
     * 当tarTypeIsZip为false时使用
     */
    private String resultString;

    /**
     * 返回.gzip的压缩包账单
     * 当tarTypeIsZip为true时使用
     */
    private InputStream resultInputStream;

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

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public InputStream getResultInputStream() {
        return resultInputStream;
    }

    public void setResultInputStream(InputStream resultInputStream) {
        this.resultInputStream = resultInputStream;
    }
}
