package com.ipaynow.sdk.api;

/**
 * @author hai 17/2/21
 */
public class IpayNowException extends Exception{
    private String errCode;
    private String errMsg;

    public IpayNowException() {
    }

    public IpayNowException(String message, Throwable cause) {
        super(message, cause);
    }

    public IpayNowException(String message) {
        super(message);
    }

    public IpayNowException(Throwable cause) {
        super(cause);
    }

    public IpayNowException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
