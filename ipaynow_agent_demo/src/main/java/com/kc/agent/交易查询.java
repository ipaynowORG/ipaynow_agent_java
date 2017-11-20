package com.kc.agent;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.QueryReqDto;
import com.ipaynow.sdk.api.dto.TransQueryRespDto;


/**
 * 
 * @author WGH
 * Date: 16-10-13
 * Time: 上午10:40
 */

public class 交易查询 {

    public static void main(String[] args) throws IpayNowException {
    	String reqUrl = "https://bc-test.ipaynow.cn/gateway";
    	String key = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
    	String merchantId="000100000000010000000000000001";
    	IpayNowClient ipayNowClient = new DefaultIpayNowClient(reqUrl, key, merchantId);
    	QueryReqDto reqDto = new QueryReqDto();
		reqDto.setAppId("1459846530407363");
		reqDto.setMhtOrderNo("CS20171106174649");
    	TransQueryRespDto respBaseDto = ipayNowClient.transQuery(reqDto);
		System.out.println(respBaseDto);
    }
}
