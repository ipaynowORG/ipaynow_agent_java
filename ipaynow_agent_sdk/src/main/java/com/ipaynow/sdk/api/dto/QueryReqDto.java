package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/2/27
 */
public class QueryReqDto {

    private String appId;
    private String mhtOrderNo;
    private String router = "00010000000003";

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

//    public String getMhtReqTime() {
//        return mhtReqTime;
//    }
//
//    public void setMhtReqTime(String mhtReqTime) {
//        this.mhtReqTime = mhtReqTime;
//    }
}
