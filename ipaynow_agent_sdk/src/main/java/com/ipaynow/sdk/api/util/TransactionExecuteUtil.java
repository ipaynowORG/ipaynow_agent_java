package com.ipaynow.sdk.api.util;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.ByteString;
import com.ipaynow.sdk.api.ApiField;
import com.ipaynow.sdk.api.IpayNowException;
import com.ipaynow.sdk.api.dto.PaymentProto;
import com.ipaynow.sdk.api.dto.ReqParamProto;
import com.ipaynow.sdk.api.dto.TransRespBaseDto;
import com.ipaynow.sdk.api.dto.TransactionProto;
import com.ipaynow.sdk.api.rpc.IpayNowRpcClient;
import com.ipaynow.sdk.api.rpc.IpayProtoRpcClient;
import com.ipaynow.sdk.api.util.crypto.ecc.ECKey;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ipaynow0407 on 2017/4/20.
 */
public class TransactionExecuteUtil {

    private static Map<String, Object> getMapFromObject(Object object, Class<?> clazz) throws IpayNowException {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                ApiField apiField = field.getAnnotation(ApiField.class);
                Method m = object.getClass().getMethod("get" + getMethodName(field.getName()));
                Object val = m.invoke(object);
                if (apiField.isRequired() && (val == null || StringUtils.isEmpty(val.toString()))) {
                    throw new IpayNowException(field.getName() + " must not null");
                }
                if (apiField == null || apiField.isKey() == false) {
                    field.setAccessible(true);
                    try {
                        map.put(field.getName(), field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IpayNowException e) {
                throw e;
            } catch (Exception e) {
                throw new IpayNowException("param error");
            }
        }
        return map;
    }

    // 把一个字符串的第一个字母大写、效率是最高的
    private static String getMethodName(String fieldName) throws Exception {
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    private static JSONObject getJSONObjectFromObject(Object object, Class<?> clazz) throws IpayNowException {
        JSONObject jsonObject = new JSONObject();
        Class<?> superClazz = clazz.getSuperclass();
        if (null != superClazz) {
            Map<String, Object> superMap = getMapFromObject(object, superClazz);
            jsonObject.putAll(superMap);
        }
        Map<String, Object> map = getMapFromObject(object, clazz);
        jsonObject.putAll(map);
        return jsonObject;
    }

    public static String getMhtField(Object object, Class<?> clazz) throws IpayNowException {
        JSONObject json = getJSONObjectFromObject(object, clazz);
        return json.toString();
    }

    private static PaymentProto.PayInvoke createPayInvoke(ByteString paramsByteString,
                                                          PaymentProto.PayInvokeMethod method) {
        PaymentProto.PayInvoke payInvoke = PaymentProto.PayInvoke.newBuilder().setParams(paramsByteString).setMethod(method).build();
        return payInvoke;
    }

    private static TransactionProto.Content createContent(ByteString payInvokeByteString, String nonce) {
        TransactionProto.Content content = TransactionProto.Content.newBuilder().setData(payInvokeByteString).setNonce(nonce).build();
        return content;
    }

    private static TransactionProto.Transaction createTransaction(ByteString contentByteString) {
        TransactionProto.Transaction transaction = TransactionProto.Transaction.newBuilder().setContent(contentByteString).setTo("1").build();
        return transaction;
    }

    private static TransactionProto.SignedTransaction createSignedTransaction(ECKey ecKey,
                                                                              TransactionProto.Transaction transaction,
                                                                              TransactionProto.Crypto crypto) {
        byte[] sign = ecKey.sign(transaction.toByteArray()).toByteArray();
        TransactionProto.SignedTransaction signedTransaction = TransactionProto.SignedTransaction.newBuilder().setTransaction(transaction.toByteString()).setCrypto(crypto).setSignature(ByteString.copyFrom(sign)).build();
        return signedTransaction;
    }

    private static ReqParamProto.Param createReqParam(TransactionProto.SignedTransaction signedTransaction,
                                                      ReqParamProto.METHOD method) {
        ReqParamProto.Param reqParam = ReqParamProto.Param.newBuilder().setMethod(method).setSign(signedTransaction).build();
        return reqParam;
    }

    public static TransRespBaseDto execute(ByteString paramsByteString, PaymentProto.PayInvokeMethod payInvokeMethod,
                                           ReqParamProto.METHOD method, String ServerUrl, ECKey ecKey,
                                           TransactionProto.Crypto crypto, String nonce) throws IpayNowException {
        TransRespBaseDto respBaseDto;
        PaymentProto.PayInvoke payInvoke = createPayInvoke(paramsByteString, payInvokeMethod);
        TransactionProto.Content content = createContent(payInvoke.toByteString(), nonce);
        TransactionProto.Transaction transaction = createTransaction(content.toByteString());
        TransactionProto.SignedTransaction signedTransaction = createSignedTransaction(ecKey, transaction, crypto);
        ReqParamProto.Param reqParam = createReqParam(signedTransaction, method);
        IpayNowRpcClient ipayNowRpcClient = new IpayProtoRpcClient(ServerUrl);
        String result = ipayNowRpcClient.execute(reqParam);
        respBaseDto = ipayNowRpcClient.generateTransResp(result, method);
        return respBaseDto;
    }
}
