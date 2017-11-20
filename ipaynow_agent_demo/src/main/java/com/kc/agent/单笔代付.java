package com.kc.agent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ipaynow.sdk.api.DefaultIpayNowClient;
import com.ipaynow.sdk.api.IpayNowClient;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.AgentPayReqDto;
import com.ipaynow.sdk.api.dto.TransRespDto;


/**
 * 
 * @author WGH
 * Date: 16-10-13
 * Time: 上午10:40
 */

public class 单笔代付  {

    public static void main(String[] args) throws IpayNowException  {
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    	String date = df.format(new Date());// 获取当前系统时间
//    	String reqUrl = "https://bc-pay.ipaynow.cn/gateway"; //正式接口
    	String reqUrl = "https://bc-test.ipaynow.cn/gateway";
        String key = "013f81ac3ee1101b620031c00eac22ab53334c083c09fc191e05c29c9f0d26ad";
		String merchantId="000100000000010000000000000001";
        IpayNowClient ipayNowClient = new DefaultIpayNowClient(reqUrl, key, merchantId);
        AgentPayReqDto agentPayReqDto = new AgentPayReqDto();
        agentPayReqDto.setMhtOrderAmt(Long.parseLong("1"));
        agentPayReqDto.setAppId("1459846530407363");
        agentPayReqDto.setAgentPayMemo("test");
        agentPayReqDto.setMhtReqTime("20170307100312");
        agentPayReqDto.setMhtOrderNo("CS"+date);
        agentPayReqDto.setAccType("0");
        agentPayReqDto.setPayeeName("张三");
        agentPayReqDto.setPayeeCardNo("6226200105111457");
        agentPayReqDto.setPayeeCardUnionNo("");
//        agentPayReqDto.setNotifyUrl("http://posp.ipaynow.cn:10808/mobilewaptest/notify");
        TransRespDto respBaseDto = ipayNowClient.agentPay(agentPayReqDto);
        System.out.println(respBaseDto);
    }
 }
