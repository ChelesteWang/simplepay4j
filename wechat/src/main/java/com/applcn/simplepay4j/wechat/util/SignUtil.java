package com.applcn.simplepay4j.wechat.util;

import com.applcn.simplepay4j.wechat.consts.WxUnifiedOrderRquestConsts;
import com.applcn.simplepay4j.core.utils.EncryptUtil;
import com.applcn.simplepay4j.core.utils.StringUtil;
import com.applcn.simplepay4j.wechat.enums.SignTypeEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 签名工具
 * @author dayaoguai
 */
public class SignUtil {

    public static String sign(Map<String,String> params, String key, SignTypeEnum signType) throws Exception {
        String sign;

        if(signType != null && SignTypeEnum.HMAC_SHA256 == signType){
            params.put(WxUnifiedOrderRquestConsts.SIGN_TYPE, signType.getValue());
            String str = String.format("%skey=%s", SignUtil.sortByAsciiAsc(params), key);
            sign = EncryptUtil.hmacSHA256(str, key);
        }else{
            String str = String.format("%skey=%s", SignUtil.sortByAsciiAsc(params), key);
            sign = EncryptUtil.md5encryption(str);
        }

        return sign;
    }

    /**
     * 设所有发送或者接收到的数据为集合M，
     * 将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），
     * 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串
     * @param map
     * @return
     */
    public static String sortByAsciiAsc(Map<String, String> map) {

        String result;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, (o1, o2) -> (o1.getKey()).toString().compareTo(o2.getKey()));
            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (!StringUtil.isEmpty(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    if (!StringUtil.isEmpty(val)) {
                        sb.append(key + "=" + val + "&");
                    }
                }
            }
            result = sb.toString();
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}
