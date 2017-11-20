package com.ipaynow.sdk.api.test;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.*;

import java.util.Date;

/**
 * Created by ipaynow0407 on 2017/6/29.
 */
public class MyTest {
    public static void main(String[] args) throws IpayNowException {
//14 代收  15代付
        String localUrl = "http://localhost:8080/gateway";
        // String localKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";

        String merchantId = "000100000000010000000000000001";

        // https://agg.ipaynow.cn/trade/gateway
        // http://123.206.13.36:8080/gateway
        // http://123.206.255.16:8080/gateway
        // 123.206.54.237
        //   String pressureUrl = "http://123.207.146.211:8080/gateway";
           String testUrl = "http://bc-test.ipaynow.cn/gateway";
       // String testUrl = "http://123.206.255.16:8080/gateway";
     //   String testUrl = "http://123.206.255.16:8080/gateway";
       //    String testUrl = "http://localhost:8080/gateway";
       // String testUrl = "http://123.206.28.151:8080/gateway";
        //   String testUrl = "https://bc.ipaynow.cn/gateway";
        // String testUrl = "http://123.207.166.24:8080/gateway";
         String testKey = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
        // String testKey = "9fa6123e333d2aed44142df0d40bc5d9d8e18eec95287a953ba5b4503fd5e63c";
    //   String testUrl = "http://120.76.2.245:8080/gateway";
       //   String testUrl = "http://localhost:8080/gateway";
       // String testUrl = "http://123.206.255.16:8080/gateway";
        String testMerchant="000100000000010000000000000001";

        String onlineUrl = "https://bc.ipaynow.cn/gateway";
        String onlineKey = "9fa6123e333d2aed44142df0d40bc5d9d8e18eec95287a953ba5b4503fd5e63c";


        IpayNowClient ipayNowClient = new DefaultIpayNowClient(testUrl, testKey, testMerchant);

        QueryReqDto reqDto = new QueryReqDto();
        reqDto.setMhtOrderNo("CS20170718234643");
        reqDto.setAppId("1459846530407363");//
        reqDto.setRouter("00010000000003");//
        TransQueryRespDto dto = ipayNowClient.transQuery(reqDto);
      //  BalanceQueryRespDto dto = ipayNowClient.balanceQuery(reqDto);
        System.out.println(dto);




    }
}
