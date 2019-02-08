package exception;

/**
 * 微信支付参数异常
 * @author dayaoguai
 */
public class WxParamException extends Exception {

    private static final long serialVersionUID = -1030416352516661471L;

    private String msg;

    public WxParamException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
