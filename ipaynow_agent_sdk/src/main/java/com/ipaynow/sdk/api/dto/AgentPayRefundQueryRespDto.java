package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/7/19
 */
public class AgentPayRefundQueryRespDto extends AgentPayRefundQueryRespField{
    private String responseCode;
    private String responseMsg;
    private String mhtOrderNo;
    private String appId;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "AgentPayRefundQueryRespDto{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                ", mhtOrderNo='" + mhtOrderNo + '\'' +
                ", appId='" + appId + '\'' +
                "} " + super.toString();
    }
}
