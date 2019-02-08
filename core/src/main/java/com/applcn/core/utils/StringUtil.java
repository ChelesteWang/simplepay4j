package com.applcn.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 字符串工具类
 * @author dayaoguai
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str) || str.length() == 0;
    }

    /**
     * 从InputStream中获取字符串
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String getString(InputStream inputStream) throws IOException {
        String s;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        inputStream.close();

        return sb.toString();
    }
}
