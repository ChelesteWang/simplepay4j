package com.applcn.simplepay4j.wechat.util;

import com.applcn.simplepay4j.wechat.consts.HttpStatusCodeConsts;
import com.applcn.simplepay4j.wechat.exception.WxRequestException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http请求工具
 * @author dayaoguai
 */
public class HttpUtil {

    /**
     * post发送xml数据，返回InputStream
     * @param requestUrl
     * @param xml
     * @return
     */
    public static InputStream postInputStream(String requestUrl, String xml){
        try {
            // 创建url资源
            URL url = new URL(requestUrl);
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);

            conn.setDoInput(true);

            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            conn.setRequestProperty("Charset", "UTF-8");
            //转换为字节数组
            byte[] requestData = xml.getBytes();
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(requestData.length));
            // 设置文件类型:
            conn.setRequestProperty("contentType", "text/xml");
            // 开始连接请求
            conn.connect();
            OutputStream  out = conn.getOutputStream();
            // 写入请求的字符串
            out.write(requestData);
            out.flush();
            out.close();

            int responseCode = conn.getResponseCode();

            // 请求返回的状态
            if (responseCode == HttpStatusCodeConsts.OK) {
                // 请求返回的数据
                InputStream in = conn.getInputStream();
                return in;
            } else {
                throw new WxRequestException(responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param requestUrl
     * @param xml
     * @return
     */
    public static String post(String requestUrl, String xml){
        InputStream in = postInputStream(requestUrl, xml);
        try {
            byte[] responseData = new byte[in.available()];
            in.read(responseData);
            // 转成字符串
            System.out.println(new String(responseData));
            return new String(responseData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
