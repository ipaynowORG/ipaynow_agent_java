package com.ipaynow.sdk.api.test;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.dto.*;

import java.util.Date;

/**
 * @author hai 17/3/1
 */
public class TransTest {

    public static void main(String[] args) throws Throwable {
        String localUrl = "http://localhost:8080/gateway";
        String localKey = "9fa6123e333d2aed44142df0d40bc5d9d8e18eec95287a953ba5b4503fd5e63c";

        String testUrl = "http://115.159.150.208:8080/gateway";
        String testKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";

        String betaUrl = "https://bc-test.ipaynow.cn/gateway";
        String betaKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";

        String preReleaseUrl = "http://120.76.4.129:8080/gateway";
        String preReleaseKey = "e9b0021ac5e996a807bb63f96460a62e73d1c4c0ebf3c8575deb1612df3d24ea";

        String onlineUrl2 = "https://bc-pay.ipaynow.cn/gateway";
        String onlineKey = "9fa6123e333d2aed44142df0d40bc5d9d8e18eec95287a953ba5b4503fd5e63c";

        String testMerchant="000100000000010000000000000001";
        String preReleaseMerchant="000100000000010000000000000002";

        String testAppId="1459846530407363";
        String onlineAppId = "1461839675773560";

        IpayNowClient ipayNowClient = new DefaultIpayNowClient(betaUrl, betaKey, testMerchant);
//
        AgentPayReqDto agentPayReqDto = new AgentPayReqDto();
        agentPayReqDto.setMhtOrderAmt(Long.parseLong("1"));
        agentPayReqDto.setAppId(testAppId);
        agentPayReqDto.setAgentPayMemo("test");
        String orderId = new Date().getTime() + "";
        System.out.println(orderId);
        agentPayReqDto.setMhtReqTime("20170307100312");
        agentPayReqDto.setMhtOrderNo(orderId);
        agentPayReqDto.setAccType("0");
        agentPayReqDto.setPayeeName("袁海杰");
        agentPayReqDto.setPayeeCardNo("6214830113071483");
        agentPayReqDto.setPayeeCardUnionNo("");
        //agentPayReqDto.setPayChannelType("15");
        //agentPayReqDto.setInvokeMode(com.ipaynow.sdk.api.dto.PaymentProto.InvokeMode.SYNC);
        agentPayReqDto.setNotifyUrl("http://mock-api.com/WmnE6LKJ.mock/tongzhi1");
        long startTime=System.currentTimeMillis();
        System.out.println(ipayNowClient.agentPay(agentPayReqDto));
        System.out.println(System.currentTimeMillis()-startTime);




//        Thread.sleep(5000);
////
//        AgentReceiveReqDto agentReceiveReqDto = new AgentReceiveReqDto();
//        agentReceiveReqDto.setAppId("1459846530407363");
//        agentReceiveReqDto.setMhtOrderAmt(Long.parseLong("201"));
//        agentReceiveReqDto.setMhtOrderNo(new Date().getTime() + "");
//        agentReceiveReqDto.setMhtReqTime("20170307100312");
//        agentReceiveReqDto.setMhtUserId("112121");
//        agentReceiveReqDto.setMhtUserCardId("21231");
//        agentReceiveReqDto.setCardNo("6226220127110178");
//        agentReceiveReqDto.setCardOwner("王伟");
//        agentReceiveReqDto.setCardType("0001");
//        agentReceiveReqDto.setCardIdenType("0001");
//        agentReceiveReqDto.setCardIdenNo("140302198210110811");
//        agentReceiveReqDto.setCardPhoneNo("A3810080328");
//        agentReceiveReqDto.setAgentPayMemo("test");
//        agentReceiveReqDto.setPayChannelType("14");
//        //agentReceiveReqDto.setInvokeMode(com.ipaynow.sdk.api.dto.PaymentProto.InvokeMode.SYNC);
//        agentReceiveReqDto.setAccType("0");
//
//        //agentReceiveReqDto.setNotifyUrl("http://mock-api.com/WmnE6LKJ.mock/tongzhi1");
//        TransRespBaseDto respBaseDto = ipayNowClient.agentReceive(agentReceiveReqDto);
//        System.out.println(respBaseDto);
//
//        Thread.sleep(5000);
//
        QueryReqDto reqDto = new QueryReqDto();
        reqDto.setAppId(testAppId);
        reqDto.setMhtOrderNo(agentPayReqDto.getMhtOrderNo());
        System.out.println(ipayNowClient.balanceQuery(reqDto));
        reqDto.setMhtOrderNo(agentPayReqDto.getMhtOrderNo());
        System.out.println(ipayNowClient.transQuery(reqDto));

        BatchQueryReqDto batchQueryReqDto = new BatchQueryReqDto();
        batchQueryReqDto.setAppId(testAppId);
        batchQueryReqDto.setMhtOrderNo("123456111");
        batchQueryReqDto.setRefundDate("20170905");
        batchQueryReqDto.setNowPage(1);
        batchQueryReqDto.setPageSize(100);
        System.out.println(ipayNowClient.agentPayRefundBatchQuery(batchQueryReqDto));

    }
}
