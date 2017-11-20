package com.ipaynow.sdk.api.test;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.dto.*;
import com.ipaynow.sdk.api.util.crypto.HashUtil;
import com.ipaynow.sdk.api.util.crypto.ecc.ECKey;
import org.spongycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author hai 17/3/1
 */
public class TransTest_New {

    public static void main(String[] args) throws Throwable {
        String localUrl = "http://localhost:8080/gateway";
        String localKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
        String merchantId = "000100000000010000000000000001";

        // https://agg.ipaynow.cn/trade/gateway
        // http://123.206.13.36:8080/gateway
        // http://123.206.255.16:8080/gateway
        // 123.206.54.237
        String pressureUrl = "http://123.206.28.151:8080/gateway";
        String testUrl = "http://bc-test.ipaynow.cn/gateway";
        String betaUrl = "http://123.206.255.16:8080/gateway";


        String testKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
        String testMerchant="000100000000010000000000000001";

        String onlineUrl = "https://bc.ipaynow.cn/gateway";
        String onlineUrl2 = "https://bc-pay.ipaynow.cn/gateway";
        String onlineKey = "9fa6123e333d2aed44142df0d40bc5d9d8e18eec95287a953ba5b4503fd5e63c";

        // 0000000000000000000000000000000000000040 http://123.206.54.237:22000
        // 0x1932c48b2bf8102ba33b4a6b545c32236e342f34 http://localhost:22000

        // 1459846530407363
        IpayNowClient ipayNowClient = new DefaultIpayNowClient(testUrl, testKey, testMerchant);
//
        long startTime=System.currentTimeMillis();
//14 代收  15代付

//        System.out.println(ipayNowClient.pay(payReqDto));
//        System.out.println(System.currentTimeMillis()-startTime);
        //
        //
        //
         //Thread.sleep(100);
        //
//         AgentReceiveReqDto agentReceiveReqDto = new AgentReceiveReqDto();
//         agentReceiveReqDto.setMhtOrderAmt(Long.parseLong("201"));
//         agentReceiveReqDto.setMhtOrderNo(new Date().getTime() + "");
//         agentReceiveReqDto.setMhtReqTime("20170307100312");
//         agentReceiveReqDto.setMhtUserId("112121");
//         agentReceiveReqDto.setMhtUserCardId("21231");
//         agentReceiveReqDto.setCardNo("6226220127110178");
//         agentReceiveReqDto.setCardOwner("王伟");
//         agentReceiveReqDto.setCardType("0001");
//         agentReceiveReqDto.setCardIdenType("0001");
//         agentReceiveReqDto.setCardIdenNo("140302198210110811");
//         agentReceiveReqDto.setCardPhoneNo("A3810080328");
//         agentReceiveReqDto.setAgentPayMemo("test");
//         agentReceiveReqDto.setAccType("0");
//         agentReceiveReqDto.setMethod(MethodEnum.AGENT_RECEIVE);
//         agentReceiveReqDto.setMhtNotifyUrl("http://mock-api.com/WmnE6LKJ.mock/tongzhi1");
//         TransRespBaseDto respBaseDto = ipayNowClient.agentReceive(agentReceiveReqDto);
//         System.out.println(respBaseDto);
        //
        // Thread.sleep(5000);
//        QueryReqDto reqDto = new QueryReqDto();
//        reqDto.setMhtOrderNo("1493805669653");
//        reqDto.setMhtReqTime("20170222160317");
//        System.out.println(ipayNowClient.transQuery(reqDto));
//         reqDto.setMhtOrderNo("20170328184235dst");
//         reqDto.setMhtReqTime("20170222160317");
//         System.out.println(ipayNowClient.balanceQuery(reqDto));
        //
        // reqDto.setMhtOrderNo(agentReceiveReqDto.getMhtOrderNo());
        // reqDto.setMhtReqTime("20170222160317");
        // System.out.println(ipayNowClient.transQuery(reqDto));
        //
        // reqDto.setMhtOrderNo("1490077434207");
        // reqDto.setMhtReqTime("20170222160317");
        // System.out.println(ipayNowClient.balanceQuery(reqDto));
        // gzh20170414145229wiY2pCpjlk8pwuKK
//        QueryReqDto reqDto = new BatchQueryReqDto();
//        reqDto.setAppId("1480586961757445");
//        reqDto.setMhtOrderNo("gzh201704141359106kYQIF2aAvyBwIzw");
//        System.out.println(ipayNowClient.agentPayRefundQuery(reqDto));
//
        BatchQueryReqDto batchQueryReqDto = new BatchQueryReqDto();
        batchQueryReqDto.setAppId("1459846530407363");
        batchQueryReqDto.setMhtOrderNo("123456");
        batchQueryReqDto.setRefundDate("20170414");
        batchQueryReqDto.setNowPage(1);
        batchQueryReqDto.setPageSize(100);
        System.out.println(ipayNowClient.agentPayRefundBatchQuery(batchQueryReqDto));
//        ECKey ecKey = ECKey.fromPrivate(new BigInteger(testKey, 16));
//        byte[] sign = ecKey.sign(HashUtil.sha3("".getBytes())).toByteArray();

//        ECKey key = new ECKey();
//        System.out.println("Secret\t: " + Hex.toHexString(key.getPrivKeyBytes()));
//        System.out.println("Pubkey\t: " + Hex.toHexString(key.getPubKey()));
    }

}
