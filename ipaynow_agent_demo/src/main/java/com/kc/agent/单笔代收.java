package com.kc.agent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.AgentReceiveReqDto;
import com.ipaynow.sdk.api.dto.TransRespBaseDto;


/**
 * 
 * @author WGH
 * Date: 16-10-13
 * Time: 上午10:40
 */

public class 单笔代收 {

    public static void main(String[] args) throws IpayNowException {
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    	String date = df.format(new Date());// 获取当前系统时间
    	String reqUrl = "https://bc-test.ipaynow.cn/gateway";
        String key = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
		String merchantId="000100000000010000000000000001";
        IpayNowClient ipayNowClient = new DefaultIpayNowClient(reqUrl, key, merchantId);
        AgentReceiveReqDto agentReceiveReqDto = new AgentReceiveReqDto();
        agentReceiveReqDto.setAppId("1459846530407363");
        agentReceiveReqDto.setMhtOrderAmt(Long.parseLong("201"));
        agentReceiveReqDto.setMhtOrderNo("CS"+date);
        agentReceiveReqDto.setMhtReqTime(date);
        agentReceiveReqDto.setMhtUserId("112121");
        agentReceiveReqDto.setMhtUserCardId("21231");
        agentReceiveReqDto.setCardNo("6226888888888888");
        agentReceiveReqDto.setCardOwner("张三");
        agentReceiveReqDto.setCardType("0001");
        agentReceiveReqDto.setCardIdenType("0001");
        agentReceiveReqDto.setCardIdenNo("14039999999999999");
        agentReceiveReqDto.setCardPhoneNo("13323233214");
        agentReceiveReqDto.setAgentPayMemo("test");
        agentReceiveReqDto.setAccType("0");
        agentReceiveReqDto.setNotifyUrl("http://posp.ipaynow.cn:10808/mobilewaptest/notify");
        TransRespBaseDto respBaseDto = ipayNowClient.agentReceive(agentReceiveReqDto);
		System.out.println(respBaseDto);
    }
}
