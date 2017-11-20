package com.ipaynow.sdk.api.rpc;

import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.ReqParamProto;
import com.ipaynow.sdk.api.dto.TransRespBaseDto;

/**
 * @author hai 17/2/22
 */
public interface IpayNowRpcClient {

    String execute(ReqParamProto.Param param) throws IpayNowException;

    TransRespBaseDto generateTransResp(String result, ReqParamProto.METHOD method) throws IpayNowException;

}
