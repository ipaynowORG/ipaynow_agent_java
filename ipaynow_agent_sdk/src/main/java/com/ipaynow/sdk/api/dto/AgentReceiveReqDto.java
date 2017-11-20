package com.ipaynow.sdk.api.dto;

import com.ipaynow.sdk.api.ApiField;

public class AgentReceiveReqDto extends TransReqBaseDto {

    @ApiField(isRequired = true)
    private String appId;

    @ApiField(isRequired = true)
    private String agentPayMemo; // 商户代收原因备注
    @ApiField(isRequired = true)
    private String mhtUserId;    // 持卡人信息
    @ApiField(isRequired = true)
    private String mhtUserCardId;// 商户持卡人信息编号
    @ApiField(isRequired = true)
    private String cardOwner;    // 持卡人姓名
    @ApiField(isRequired = true)
    private String cardType;     // 银行卡类别
    @ApiField(isRequired = true)
    private String cardNo;       // 银行卡号
    @ApiField
    private String cvv2;
    @ApiField
    private String validThru;
    @ApiField(isRequired = true)
    private String cardIdenType;
    @ApiField(isRequired = true)
    private String cardIdenNo;
    @ApiField(isRequired = true)
    private String cardPhoneNo;
    @ApiField(isRequired = true)
    private String accType;

    @ApiField
    private String notifyUrl;
    @ApiField(isRequired = true)
    private String payChannelType= "14";

    @ApiField(isRequired = true)
    private String deviceType = "12";
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

    public String getAgentPayMemo() {
        return agentPayMemo;
    }

    public void setAgentPayMemo(String agentPayMemo) {
        this.agentPayMemo = agentPayMemo;
    }

    public String getMhtUserId() {
        return mhtUserId;
    }

    public void setMhtUserId(String mhtUserId) {
        this.mhtUserId = mhtUserId;
    }

    public String getMhtUserCardId() {
        return mhtUserCardId;
    }

    public void setMhtUserCardId(String mhtUserCardId) {
        this.mhtUserCardId = mhtUserCardId;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    public String getCardIdenType() {
        return cardIdenType;
    }

    public void setCardIdenType(String cardIdenType) {
        this.cardIdenType = cardIdenType;
    }

    public String getCardIdenNo() {
        return cardIdenNo;
    }

    public void setCardIdenNo(String cardIdenNo) {
        this.cardIdenNo = cardIdenNo;
    }

    public String getCardPhoneNo() {
        return cardPhoneNo;
    }

    public void setCardPhoneNo(String cardPhoneNo) {
        this.cardPhoneNo = cardPhoneNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
