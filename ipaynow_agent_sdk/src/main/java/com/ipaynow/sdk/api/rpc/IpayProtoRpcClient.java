package com.ipaynow.sdk.api.rpc;

import com.alibaba.fastjson.JSONObject;
import com.ipaynow.sdk.api.*;
import com.ipaynow.sdk.api.dto.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.SocketTimeoutException;

/**
 * @author hai 17/2/22
 */
public class IpayProtoRpcClient implements IpayNowRpcClient {

    private String reqUrl;
    private int    connectTimeout;
    private int    readTimeout;

    public IpayProtoRpcClient(String reqUrl){
        this.reqUrl = reqUrl;
        this.connectTimeout = 5000;
        this.readTimeout = 30 * 1000;
    }

    public String execute(ReqParamProto.Param param) throws IpayNowException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(param.toByteArray());
            InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);

            // 这两行很重要的，是告诉springmvc客户端请求和响应的类型，指定application/x-protobuf类型,spring会用ProtobufHttpMessageConverter类来解析请求和响应的实体
            HttpPost httpPost = new HttpPost(reqUrl);
            httpPost.addHeader("Content-Type", "application/x-protobuf");
            httpPost.addHeader("Accept", "application/x-protobuf");
            httpPost.setEntity(inputStreamEntity);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(readTimeout).build();
            httpPost.setConfig(requestConfig);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {
                HttpEntity entity = response.getEntity();
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                entity.writeTo(buf);
                ParamProto.ReqParam respMsg = ParamProto.ReqParam.parseFrom(buf.toByteArray());
                return respMsg.getMsg();

            } finally {
                response.close();
            }
        }catch (SocketTimeoutException e){
            throw new IpayNowException("http request time out : " + e.getMessage());
        }catch (Exception e) {
            throw new IpayNowException("http request error : " + e.getMessage());
        }
    }

    public TransRespBaseDto generateTransResp(String result, ReqParamProto.METHOD method) throws IpayNowException {
        switch (method) {
            case TRANS:
                TransRespBaseDto respBaseDto =JSONObject.parseObject(result,TransRespBaseDto.class);
                return respBaseDto;
            case QUERY_TRANS_DETAIL:
                TransQueryRespDto transQueryRespDto = JSONObject.parseObject(result,TransQueryRespDto.class);
                return transQueryRespDto;
            default:
                return null;
        }
    }
}
