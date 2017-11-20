package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/2/27
 */
public class TransRespDto extends TransRespBaseDto {

    private String nowPayOrderNo;
    private String transStatus;

    public String getNowPayOrderNo() {
        return nowPayOrderNo;
    }

    public void setNowPayOrderNo(String nowPayOrderNo) {
        this.nowPayOrderNo = nowPayOrderNo;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    @Override
    public String toString() {
        return "TransRespDto{" +
                "nowPayOrderNo='" + nowPayOrderNo + '\'' +
                ", transStatus='" + transStatus + '\'' +
                "} " + super.toString();
    }
}
