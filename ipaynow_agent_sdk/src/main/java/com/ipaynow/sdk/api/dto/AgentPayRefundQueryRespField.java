package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/7/19
 */
public class AgentPayRefundQueryRespField{

    private String nowPayOrderNo;

    private String originalMhtOrderNo;

    private String originalNowPayOrderNo;

    private String payeeAccType;

    private String payeeName;

    private String payeeCardNo;

    private String payeeCardUnionNo;

    private String refundDate;

    private String refundCode;

    private String refundMsg;

    private String transStatus;

    public String getNowPayOrderNo() {
        return nowPayOrderNo;
    }

    public void setNowPayOrderNo(String nowPayOrderNo) {
        this.nowPayOrderNo = nowPayOrderNo;
    }

    public String getOriginalMhtOrderNo() {
        return originalMhtOrderNo;
    }

    public void setOriginalMhtOrderNo(String originalMhtOrderNo) {
        this.originalMhtOrderNo = originalMhtOrderNo;
    }

    public String getOriginalNowPayOrderNo() {
        return originalNowPayOrderNo;
    }

    public void setOriginalNowPayOrderNo(String originalNowPayOrderNo) {
        this.originalNowPayOrderNo = originalNowPayOrderNo;
    }

    public String getPayeeAccType() {
        return payeeAccType;
    }

    public void setPayeeAccType(String payeeAccType) {
        this.payeeAccType = payeeAccType;
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

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public String getRefundMsg() {
        return refundMsg;
    }

    public void setRefundMsg(String refundMsg) {
        this.refundMsg = refundMsg;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    @Override
    public String toString() {
        return "AgentPayRefundQueryRespField{" +
                "nowPayOrderNo='" + nowPayOrderNo + '\'' +
                ", originalMhtOrderNo='" + originalMhtOrderNo + '\'' +
                ", originalNowPayOrderNo='" + originalNowPayOrderNo + '\'' +
                ", payeeAccType='" + payeeAccType + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", payeeCardNo='" + payeeCardNo + '\'' +
                ", payeeCardUnionNo='" + payeeCardUnionNo + '\'' +
                ", refundDate='" + refundDate + '\'' +
                ", refundCode='" + refundCode + '\'' +
                ", refundMsg='" + refundMsg + '\'' +
                ", transStatus='" + transStatus + '\'' +
                '}';
    }
}
