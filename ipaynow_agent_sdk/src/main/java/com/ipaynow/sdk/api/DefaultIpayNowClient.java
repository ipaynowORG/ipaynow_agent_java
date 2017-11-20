package com.ipaynow.sdk.api;

import java.math.BigInteger;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.ByteString;
import com.ipaynow.sdk.api.dto.*;
import com.ipaynow.sdk.api.rpc.IpayNowRpcClient;
import com.ipaynow.sdk.api.rpc.IpayProtoRpcClient;
import com.ipaynow.sdk.api.util.TransactionExecuteUtil;
import com.ipaynow.sdk.api.util.crypto.HashUtil;
import com.ipaynow.sdk.api.util.crypto.ecc.ECKey;
import org.apache.commons.lang3.StringUtils;
import org.spongycastle.util.encoders.Hex;

/**
 * @author hai 17/2/17
 */
public class DefaultIpayNowClient implements IpayNowClient {

    private String serverUrl;

    private String privateKey;

    private String merchantId;

    public DefaultIpayNowClient(String serverUrl, String privateKey, String merchantId){
        this.serverUrl = serverUrl;
        this.privateKey = privateKey;
        this.merchantId = merchantId;
    }

    public TransQueryRespDto transQuery(QueryReqDto reqDto) throws IpayNowException {

        PaymentProto.QueryDetailParams params = PaymentProto.QueryDetailParams.newBuilder().setAppId(reqDto.getAppId()).setTransId(reqDto.getMhtOrderNo()).setRouter(reqDto.getRouter()).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.QUERY_METHOD).build();
        String nonce = merchantId + "_" + reqDto.getMhtOrderNo();
        // 交易发往区块链的方法
        String result = trans(payInvoke, ReqParamProto.METHOD.QUERY_TRANS_DETAIL, nonce);
        TransQueryRespDto transQueryRespDto = JSONObject.parseObject(result, TransQueryRespDto.class);
        return transQueryRespDto;
    }

    public TransRespDto agentPay(AgentPayReqDto agentPayReqDto) throws IpayNowException {

        String mhtField = TransactionExecuteUtil.getMhtField(agentPayReqDto, AgentPayReqDto.class);
        PaymentProto.PayRequestParams params = PaymentProto.PayRequestParams.newBuilder().setTransId(agentPayReqDto.getMhtOrderNo()).setChannelType("15").setAmount(agentPayReqDto.getMhtOrderAmt()).setRouter(agentPayReqDto.getRouter()).setMhtField(mhtField).setMode(PaymentProto.InvokeMode.SYNC).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.PAY_REQUEST_METHOD).build();
        String nonce = merchantId + "_" + agentPayReqDto.getMhtOrderNo() + "_" + agentPayReqDto.getPayChannelType();
        // 交易发往区块链的方法
        String result = trans(payInvoke, ReqParamProto.METHOD.TRANS, nonce);
        TransRespDto respBaseDto = JSONObject.parseObject(result, TransRespDto.class);
        respBaseDto.setMhtOrderNo(agentPayReqDto.getMhtOrderNo());
        return respBaseDto;
    }

    public TransRespDto agentReceive(AgentReceiveReqDto agentReceiveReqDto) throws IpayNowException {

        String mhtFeild = TransactionExecuteUtil.getMhtField(agentReceiveReqDto, AgentReceiveReqDto.class);
        PaymentProto.PayRequestParams params = PaymentProto.PayRequestParams.newBuilder().setTransId(agentReceiveReqDto.getMhtOrderNo()).setChannelType("14").setAmount(agentReceiveReqDto.getMhtOrderAmt()).setRouter(agentReceiveReqDto.getRouter()).setMhtField(mhtFeild).setMode(PaymentProto.InvokeMode.SYNC).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.PAY_REQUEST_METHOD).build();
        String nonce = merchantId + "_" + agentReceiveReqDto.getMhtOrderNo() + "_"
                       + agentReceiveReqDto.getPayChannelType();
        String result = trans(payInvoke, ReqParamProto.METHOD.TRANS, nonce);
        TransRespDto respBaseDto = JSONObject.parseObject(result, TransRespDto.class);
        respBaseDto.setMhtOrderNo(agentReceiveReqDto.getMhtOrderNo());
        return respBaseDto;
    }

    public BalanceQueryRespDto balanceQuery(QueryReqDto reqDto) throws IpayNowException {
        PaymentProto.QueryDetailParams params = PaymentProto.QueryDetailParams.newBuilder().setAppId(reqDto.getAppId()).setTransId(reqDto.getMhtOrderNo()).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.QUERY_METHOD).build();
        String nonce = merchantId + "_" + reqDto.getMhtOrderNo();
        String result = trans(payInvoke, ReqParamProto.METHOD.QUERY_BALANCE_V1, nonce);
        BalanceQueryRespDto balanceQueryRespDto = JSONObject.parseObject(result, BalanceQueryRespDto.class);
        balanceQueryRespDto.setMhtOrderNo(reqDto.getMhtOrderNo());
        balanceQueryRespDto.setAppId(reqDto.getAppId());
        return balanceQueryRespDto;
    }

    public AgentPayRefundQueryRespDto agentPayRefundQuery(QueryReqDto reqDto) throws IpayNowException {
        PaymentProto.QueryAgentPayRefundParams params = PaymentProto.QueryAgentPayRefundParams.newBuilder().setAppId(reqDto.getAppId()).setTransId(reqDto.getMhtOrderNo()).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.QUERY_METHOD).build();
        String nonce = merchantId + "_" + reqDto.getMhtOrderNo();
        // 交易发往区块链的方法
        String result = trans(payInvoke, ReqParamProto.METHOD.AGENT_PAY_REFUND_QUERY, nonce);
        AgentPayRefundQueryRespDto respDto = JSONObject.parseObject(result, AgentPayRefundQueryRespDto.class);
        return respDto;
    }

    public AgentPayRefundBatchQueryRespDto agentPayRefundBatchQuery(BatchQueryReqDto reqDto) throws IpayNowException {
        PaymentProto.QueryAgentPayRefundParams params = PaymentProto.QueryAgentPayRefundParams.newBuilder().setAppId(reqDto.getAppId()).setTransId(reqDto.getMhtOrderNo()).setNowPage(reqDto.getNowPage()).setPageSize(reqDto.getPageSize()).setRefundDate(reqDto.getRefundDate()).build();
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(params.toByteString()).setMethod(PaymentProto.PayInvokeMethod.QUERY_METHOD).build();
        String nonce = merchantId + "_" + reqDto.getMhtOrderNo();
        // 交易发往区块链的方法
        String result = trans(payInvoke, ReqParamProto.METHOD.AGENT_PAY_REFUND_BATCH_QUERY, nonce);
        JSONObject jsonObject= JSON.parseObject(result);
        AgentPayRefundBatchQueryRespDto respDto = JSONObject.parseObject(result, AgentPayRefundBatchQueryRespDto.class);
        if(StringUtils.isNotBlank(jsonObject.getString("refundDatas"))){
            List<AgentPayRefundQueryRespField> agentPayRefundQueryRespFieldList =JSON.parseArray(jsonObject.getString("refundDatas"),AgentPayRefundQueryRespField.class);
            respDto.setAgentPayRefundQueryRespFieldList(agentPayRefundQueryRespFieldList);
        }
        return respDto;
    }

    private String trans(PaymentProto.PayInvoke payInvoke, ReqParamProto.METHOD method,
                         String nonce) throws IpayNowException {
        ECKey ecKey = ECKey.fromPrivate(new BigInteger(privateKey, 16));
        TransactionProto.Content content = TransactionProto.Content.newBuilder().setData(payInvoke.toByteString()).setNonce(nonce).build();
        TransactionProto.Transaction transaction = TransactionProto.Transaction.newBuilder().setContent(content.toByteString()).setFrom(merchantId).build();
        byte[] sign = ecKey.sign(HashUtil.sha3(transaction.toByteArray())).toByteArray();
        TransactionProto.SignedTransaction signedTransaction = TransactionProto.SignedTransaction.newBuilder().setTransaction(transaction.toByteString()).setCrypto(TransactionProto.Crypto.SECP).setSignature(ByteString.copyFrom(sign)).build();
        ReqParamProto.Param reqParam = ReqParamProto.Param.newBuilder().setMethod(method).setSign(signedTransaction).build();
        IpayNowRpcClient ipayNowRpcClient = new IpayProtoRpcClient(serverUrl);
        String result = ipayNowRpcClient.execute(reqParam);
        return result;
    }
}
