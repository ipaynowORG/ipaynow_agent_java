package com.ipaynow.sdk.api.dto;

import com.ipaynow.sdk.api.ApiField;

/**
 * @author hai 17/2/23
 */
public class TransReqBaseDto {

    /**
     * 商户订单号
     */
    @ApiField(isKey = true,isRequired = true)
    private String     mhtOrderNo;

    /**
     * 金额
     */
    @ApiField(isKey = true,isRequired = true)
    private Long       mhtOrderAmt;

    @ApiField(isKey = true,isRequired = true)
    private String    router = "00010000000003";

    /**
     * 交互模式
     */
    @ApiField(isKey = true,isRequired = true)
    private PaymentProto.InvokeMode invokeMode = PaymentProto.InvokeMode.SYNC;


    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public Long getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(Long mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getRouter() {
        return router;
    }

    public PaymentProto.InvokeMode getInvokeMode() {
        return invokeMode;
    }

    public void setInvokeMode(PaymentProto.InvokeMode invokeMode) {
        this.invokeMode = invokeMode;
    }
}
