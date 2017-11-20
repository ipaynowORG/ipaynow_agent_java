package com.kc.sign;

import java.math.BigInteger;
import java.util.Map;

import org.spongycastle.util.encoders.Hex;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipaynow.sdk.api.util.StringTools;
import com.ipaynow.sdk.api.util.crypto.HashUtil;
import com.ipaynow.sdk.api.util.crypto.ecc.ECKey;


public class Sign {
	public static boolean verify(String data, String pub) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
			Map<String, Object> map = mapper.readValue(data, Map.class);
            BigInteger r = new BigInteger(map.get("sign_r").toString(), 16);
            BigInteger s = new BigInteger(map.get("sign_s").toString(), 16);
            int v = Integer.parseInt(map.get("sign_v").toString());
            String param = StringTools.postFormLinkReport((Map) map.get("data"));
            ECKey.ECDSASignature sig = 
            ECKey.ECDSASignature.fromComponents(r.toByteArray(), s.toByteArray(),
                    (byte) v);
            ECKey key = ECKey.fromPublicOnly(Hex.decode(pub));
            return key.verify(HashUtil.sha3(param.getBytes("UTF-8")), sig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	public static void main(String[] args) {
		Sign s=new Sign();
		String data="{\"data\":{\"responseCode\":\"A001\",\"transType\":\"AGENT_PAY\",\"chTransId\":\"200003201706281611301869886\",\"mhtOrderNo\":\"1498637485119\",\"responseMsg\":\"成功\",\"transStatus\":\"SUCCESSED\",\"responseTime\":\"20170628161137\",\"mhtOrderAmt\":1},\"sign_v\":27,\"sign_r\":\"b1e545850890a10f14b820675dc0258839b72c05fe562ff99b858f5741ff9a29\",\"sign_s\":\"5be45874b4bfa474835f400c4fcba05e5026e1d790513cbd1f40cbe0ad4642f4\"}";
		boolean b=s.verify(data, "048a6fc962b5d40ae3253d3231f7742c66334cc6eb516ac3499c00358964e3421569058bccd4437c55ca391559fea98f2b78a20400d6df39f0ef4715ce5dcdbd57");
		System.out.println(b);
	}
}