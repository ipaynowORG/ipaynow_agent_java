package com.kc.agent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.AgentPayRefundBatchQueryRespDto;
import com.ipaynow.sdk.api.dto.BatchQueryReqDto;



/**
 * 
 * @author WGH Date: 17-07-21 Time: 上午09:40
 */

public class 批量退票查询 {

	public static void main(String[] args) throws IpayNowException  {
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    	String date = df.format(new Date());// 获取当前系统时间
//    	String reqUrl = "https://bc-pay.ipaynow.cn/gateway"; //正式接口
    	String reqUrl = "https://bc-test.ipaynow.cn/gateway";
        String key = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
		String merchantId="000100000000010000000000000001";
        IpayNowClient ipayNowClient = new DefaultIpayNowClient(reqUrl, key, merchantId);
        BatchQueryReqDto batchQueryReqDto = new BatchQueryReqDto();
        batchQueryReqDto.setAppId("1459846530407363");
        batchQueryReqDto.setMhtOrderNo("CS"+date);
        batchQueryReqDto.setRefundDate("20170414");
        batchQueryReqDto.setNowPage(1);
        batchQueryReqDto.setPageSize(100);
        AgentPayRefundBatchQueryRespDto respDto = ipayNowClient.agentPayRefundBatchQuery (batchQueryReqDto);
        System.out.println(respDto);

	}
}
