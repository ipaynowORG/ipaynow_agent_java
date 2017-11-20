package com.ipaynow.sdk.api.dto;

import java.util.List;

/**
 * @author hai 17/7/19
 */
public class AgentPayRefundBatchQueryRespDto{
    private String responseCode;
    private String responseMsg;
    private String mhtOrderNo;
    private String appId;
    private Integer nowPage;
    private Integer pageSize;
    private Integer countNums;
    private Integer countPages;

    private List<AgentPayRefundQueryRespField> agentPayRefundQueryRespFieldList;

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

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<AgentPayRefundQueryRespField> getAgentPayRefundQueryRespFieldList() {
        return agentPayRefundQueryRespFieldList;
    }

    public Integer getCountNums() {
        return countNums;
    }

    public void setCountNums(Integer countNums) {
        this.countNums = countNums;
    }

    public Integer getCountPages() {
        return countPages;
    }

    public void setCountPages(Integer countPages) {
        this.countPages = countPages;
    }

    public void setAgentPayRefundQueryRespFieldList(List<AgentPayRefundQueryRespField> agentPayRefundQueryRespFieldList) {
        this.agentPayRefundQueryRespFieldList = agentPayRefundQueryRespFieldList;
    }

    @Override
    public String toString() {
        return "AgentPayRefundBatchQueryRespDto{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                ", mhtOrderNo='" + mhtOrderNo + '\'' +
                ", appId='" + appId + '\'' +
                ", nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                ", countNums=" + countNums +
                ", countPages=" + countPages +
                ", agentPayRefundQueryRespFieldList=" + agentPayRefundQueryRespFieldList +
                '}';
    }
}
