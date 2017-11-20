package com.ipaynow.sdk.api.util;

/**
 * Created by ipaynow0407 on 2017/7/7.
 */
public enum ResponseCodeEnum {
    SUCCESS("0000", "成功"), PROCESS("0001", "处理中"), FAIL("0002", "失败"),
    DATABASE_ERROR("0003", "数据库异常"), REQ_ERROR("0004", "请求出错"),
    JSON_PARSE_ERROR("0005", "json转换出错"),

    EHT_ERROR("1000", "请求区块链出错"), CITA_ERROR("1001", "请求区块链cita出错"),

    TRANS_EXISTING("2000", "交易已存在"), MERCHANT_INFO_NOT_EXIST("2001", "商户信息不存在"),
    TRANS_NOT_EXISTED("2002", "交易不存在"), POLY_REQ_ERROR("2003", "请求聚合出错"),
    TRANS_QUERY_ERROR("2004", "交易查询出错"), AGENT_PAY_ERROR("2005", "请求代付出错"),
    AGENT_RECEIVE_ERROR("2006", "请求代收出错"), QUERY_BALANCE_ERROR("2007", "查询余额出错"),
    IS_SCANPAY_ERROR("2008", "交易为被扫交易，跳过"), IS_AGENTPAY_ERROR("2009", "交易为代收付交易，跳过"),
    ORDER_NOTIFIED("2010", "订单已确认"), REQ_PARAM_ERROR("2011", "请求参数错误"),
    /**
     * 系统相关异常
     **/
    SYSTEM_ERROR("9999", "系统异常");

    private String code;
    private String description;

    ResponseCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ResponseCodeEnum getEnum(String code) {
        for (ResponseCodeEnum status : ResponseCodeEnum.values()) {
            if (status.getCode().equals(code)) return status;
        }
        return null;
    }

}
