package com.ipaynow.sdk.api.dto;

import com.ipaynow.sdk.api.ApiField;

public class AgentPayReqDto extends TransReqBaseDto {

    /**
     * 应用编号
     */
    @ApiField(isRequired = true)
    private String appId;

    /**
     * 入账账户类型
     */
    @ApiField(isRequired = true)
    private String accType;

    /**
     * 入账账户户名
     */
    @ApiField(isRequired = true)
    private String payeeName;

    /**
     * 入账账户账号
     */
    @ApiField(isRequired = true)
    private String payeeCardNo;

    /**
     * 入账账户联行号
     */
    @ApiField
    private String payeeCardUnionNo;

    /**
     * 资金用途
     */
    @ApiField(isRequired = true)
    private String agentPayMemo;

    @ApiField
    private String notifyUrl;

    @ApiField(isRequired = true)
    private String payChannelType = "15";

    @ApiField(isRequired = true)
    private String deviceType = "13";

    @ApiField(isRequired = true)
    private String mhtReqTime;

    public String getMhtReqTime() {
        return mhtReqTime;
    }

    public void setMhtReqTime(String mhtReqTime) {
        this.mhtReqTime = mhtReqTime;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeCardNo() {
        return payeeCardNo;
    }

    public void setPayeeCardNo(String payeeCardNo) {
        this.payeeCardNo = payeeCardNo;
    }

    public String getPayeeCardUnionNo() {
        return payeeCardUnionNo;
    }

    public void setPayeeCardUnionNo(String payeeCardUnionNo) {
        this.payeeCardUnionNo = payeeCardUnionNo;
    }

    public String getAgentPayMemo() {
        return agentPayMemo;
    }

    public void setAgentPayMemo(String agentPayMemo) {
        this.agentPayMemo = agentPayMemo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

}
