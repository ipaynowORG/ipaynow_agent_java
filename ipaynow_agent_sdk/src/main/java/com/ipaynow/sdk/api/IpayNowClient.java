package com.ipaynow.sdk.api;

import com.ipaynow.sdk.api.dto.*;

/**
 * @author hai 17/2/17
 */
public interface IpayNowClient {



    TransQueryRespDto transQuery(QueryReqDto reqDto) throws IpayNowException;

    TransRespDto agentPay(AgentPayReqDto agentPayReqDto) throws IpayNowException;

    TransRespDto agentReceive(AgentReceiveReqDto agentReceiveReqDto) throws IpayNowException;

    BalanceQueryRespDto balanceQuery(QueryReqDto reqDto) throws IpayNowException;

    AgentPayRefundQueryRespDto agentPayRefundQuery(QueryReqDto reqDto) throws IpayNowException;

    AgentPayRefundBatchQueryRespDto agentPayRefundBatchQuery(BatchQueryReqDto reqDto) throws IpayNowException;

}
