package com.applcn.simplepay4j.wechat.response;

import com.applcn.simplepay4j.core.result.DownloadbillResult;

import java.io.InputStream;

/**
 * 微信下载对账单返回结果
 * @author dayaoguai
 */
public class WxDownloadbillResponse implements DownloadbillResult {

    private static final long serialVersionUID = -6047690943679958308L;

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