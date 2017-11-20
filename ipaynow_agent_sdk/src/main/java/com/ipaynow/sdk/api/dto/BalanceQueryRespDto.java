package com.ipaynow.sdk.api.dto;

/**
 * @author hai 17/2/27
 */
public class BalanceQueryRespDto extends TransRespBaseDto {

    private Long   accountBalance;

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "BalanceQueryRespDto{" +
                "accountBalance=" + accountBalance +
                "} " + super.toString();
    }
}
