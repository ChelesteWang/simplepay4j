package com.applcn.example.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author dayaoguai
 */
public class EncryptUtil {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     * 此处用了AES/ECB/PKCS5Padding，而微信要求AES/ECB/PKCS7Padding，因为原生java不支持AES/ECB/PKCS7Padding
     * 据查两种算法唯一区别是块大小不一样，AES/ECB/PKCS5Padding明确要求8位，AES/ECB/PKCS7Padding可以是1-255位之间
     * 此处可能存在bug
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";

    /**
     * 编码格式
     */
    private static final String ENCODING = "UTF-8";

    /**
     * md5 32位小写加密
     * @param plainText 明文
     * @return 32位密文
     */
    public static String md5encryption(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String hmacSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(ENCODING), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes(ENCODING));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }


    /**
     * @param content  要被加密的字符串
     * @param key  加/解密要用的长度为32的字节数组（256位）密钥
     * @return byte[]  加密后的字节数组
     */
    public static String aes256Encode(String content, String key) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        // 初始化
        SecretKeySpec secretKeySpec = new SecretKeySpec(md5encryption(key).getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return base64Encode(cipher.doFinal(content.getBytes()));
    }

    /**
     * @param  cryptograph  要被解密的字节数组
     * @param  key    加/解密要用的长度为32的字节数组（256位）密钥
     * @return String  解密后的字符串
     */
    public static String aes256Decode(String cryptograph, String key) throws Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        SecretKeySpec secretKeySpec = new SecretKeySpec(md5encryption(key).getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(cipher.doFinal(base64Decode(cryptograph)));
    }

    /**
     * 将 bytes 进行 BASE64 编码
     * @param bytes
     * @return
     */
    public static String base64Encode(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * 将 str 进行 BASE64 编码
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return base64Encode(str.getBytes(ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将 BASE64 编码的字符串 str 进行解码返回字符串
     * @param str
     * @return
     */
    public static String base64DecodeString(String str) throws UnsupportedEncodingException {
        return new String(base64Decode(str),ENCODING);
    }

    /**
     * 将 BASE64 编码的字符串 str 进行解码返回byte[]
     * @param str
     * @return
     */
    public static byte[] base64Decode(String str) {
        if (str == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(str);
            return b;
        } catch (Exception e) {
            return null;
        }
    }
}