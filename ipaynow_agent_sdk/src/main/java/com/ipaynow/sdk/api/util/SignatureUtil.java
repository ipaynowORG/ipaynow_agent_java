package com.ipaynow.sdk.api.util;

import com.alibaba.fastjson.JSONObject;
import com.ipaynow.sdk.api.util.crypto.HashUtil;
import com.ipaynow.sdk.api.util.crypto.ecc.ECKey;
import org.spongycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.util.Map;

/**
 * @author hai 17/3/23
 */
public class SignatureUtil {

    public static boolean verify(String data, String pub) {
        try {
            Map<String, Object> map = JSONObject.parseObject(data, Map.class);
            BigInteger r = new BigInteger(map.get("sign_r").toString(), 16);
            BigInteger s = new BigInteger(map.get("sign_s").toString(), 16);
            int v = Integer.parseInt(map.get("sign_v").toString());
            String param = StringTools.postFormLinkReport((Map) map.get("data"));
            ECKey.ECDSASignature sig = ECKey.ECDSASignature.fromComponents(r.toByteArray(), s.toByteArray(),
                    (byte) v);
            ECKey key = ECKey.fromPublicOnly(Hex.decode(pub));
            return key.verify(HashUtil.sha3(param.getBytes("UTF-8")), sig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
