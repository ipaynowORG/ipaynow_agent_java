package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/2/27
 */
public class TransQueryRespDto extends TransRespBaseDto {

    /**
     * 现在支付流水号
     */
    private String nowPayOrderNo;
    /**
     * 交易类型
     */
    private String transType;
    /**
     * 交易金额
     */
    private Long mhtOrderAmt;

    private String transStatus;


    public String getNowPayOrderNo() {
        return nowPayOrderNo;
    }


    public void setNowPayOrderNo(String nowPayOrderNo) {
        this.nowPayOrderNo = nowPayOrderNo;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Long getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(Long mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    @Override
    public String toString(){
        return "TransQueryRespDto{" +
                    "nowPayOrderNo='" + nowPayOrderNo + '\'' +
                    ", transType='" + transType + '\'' +
                    ", mhtOrderAmt=" + mhtOrderAmt +
                    ", transStatus='" + transStatus + '\'' +
                    "} " + super.toString();
    }
}
