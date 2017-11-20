package com.kc.agent;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.AgentPayRefundQueryRespDto;
import com.ipaynow.sdk.api.dto.BatchQueryReqDto;
import com.ipaynow.sdk.api.dto.QueryReqDto;

/**
 * 
 * @author WGH Date: 17-07-21 Time: 上午09:40
 */

public class 单笔退票查询 {

	public static void main(String[] args) throws IpayNowException  {
//    	String reqUrl = "https://bc-pay.ipaynow.cn/gateway"; //正式接口
    	String reqUrl = "https://bc-test.ipaynow.cn/gateway";
        String key = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
		String merchantId="000100000000010000000000000001";
        IpayNowClient ipayNowClient = new DefaultIpayNowClient(reqUrl, key, merchantId);
        QueryReqDto reqDto = new BatchQueryReqDto();
        reqDto.setAppId("1459846530407363");
        reqDto.setMhtOrderNo("gzh20170414145229wiY2pCpjlk8pwuKK");
        AgentPayRefundQueryRespDto respDto = ipayNowClient.agentPayRefundQuery(reqDto);
        System.out.println(respDto);
	}
}
