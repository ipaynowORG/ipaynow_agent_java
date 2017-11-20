package com.ipaynow.sdk.api;

/**
 * @author hai 17/2/23
 */
public enum TransStatusEnum {
                             PROCESSING("处理中"), SUCCESSED("成功"), FAILED("失败");

    private String desc;

    TransStatusEnum(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public TransStatusEnum getTransStatus(String transStatus) {
        for (TransStatusEnum statusEnum : TransStatusEnum.values()) {
            if (statusEnum.name().equals(transStatus)) return statusEnum;
        }
        return null;
    }
}
