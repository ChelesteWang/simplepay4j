package com.applcn.simplepay4j.wechat.consts;

/**
 * Http常用状态码常量
 * @author dayaoguai
 */
public class HttpStatusCodeConsts {

    /**
     * 成功
     */
    public static int OK = 200;

    /**
     * 服务器未能理解请求或是请求参数有误
     */
    public static int BAD_REQUEST = 400;

    /**
     * 被请求的页面需要用户名和密码
     */
    public static int UNAUTTHORIZED = 401;

    /**
     * 对被请求页面的访问被禁止
     */
    public static int FORBidden = 403;

    /**
     * 服务器无法找到被请求的页面
     */
    public static int NOT_FOUND = 404;

    /**
     * 请求中指定的方法不被允许
     */
    public static int METHOD_NOT_ALLOWED = 405;

    /**
     * 由于媒介类型不被支持，服务器不会接受请求
     */
    public static int UNSUPPORTED_MEDIA_TYPE = 415;

    /**
     * 请求未完成。服务器遇到不可预知的情况
     */
    public static int INTELNAL_SERVER_ERROR = 500;

    /**
     * 请求未完成。服务器从上游服务器收到一个无效的响应
     */
    public static int BAT_GATEWAY = 502;

    /**
     * 请求未完成。服务器临时过载或当机
     */
    public static int SERVICE_UNVAILABLE = 503;

    /**
     * 网关超时
     */
    public static int GATEWAY_TIMEOUT = 504;
}