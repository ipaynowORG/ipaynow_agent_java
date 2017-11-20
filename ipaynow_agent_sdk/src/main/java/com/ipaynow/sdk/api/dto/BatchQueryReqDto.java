package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/2/27
 */
public class BatchQueryReqDto extends QueryReqDto {

    private Integer nowPage;
    private Integer pageSize;
    private String refundDate;

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

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    @Override
    public String toString() {
        return "BatchQueryReqDto{" +
                "nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                ", refundDate='" + refundDate + '\'' +
                "} " + super.toString();
    }
}
