package com.ipaynow.sdk.api.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * hex to string
 */
public class StringTools {

    private static String      hexString       = "0123456789ABCDEF";

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static String postFormLinkReport(Map dataMap) {

        StringBuilder reportBuilder = new StringBuilder();

        List<String> keyList = new ArrayList<String>(dataMap.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            if (StringUtils.isNotBlank(dataMap.get(key).toString()))
                reportBuilder.append(key + "=" + dataMap.get(key) + "&");
        }

        reportBuilder.deleteCharAt(reportBuilder.lastIndexOf("&"));

        return reportBuilder.toString();
    }

    static public String strToHexStr(String str) {
        String res = "";
        int ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            res += String.format("%02X", ch);
        }
        return res;
    }

    /*
     * 将16进制编码数字转成字符串
     */
    public static String hexToString(String hexStr, String charset) {
        if (null == hexStr || "".equals(hexStr) || (hexStr.length()) % 2 != 0) {
            return null;
        }

        int byteLength = hexStr.length() / 2;
        byte[] bytes = new byte[byteLength];

        int temp;
        for (int i = 0; i < byteLength; i++) {
            temp = hex2Dec(hexStr.charAt(2 * i)) * 16 + hex2Dec(hexStr.charAt(2 * i + 1));
            bytes[i] = (byte) (temp < 128 ? temp : temp - 256);
        }
        try {
            return new String(bytes, charset);
        } catch (UnsupportedEncodingException e) {

        }
        return null;
    }

    private static int hex2Dec(char ch) {
        if (ch == '0') return 0;
        if (ch == '1') return 1;
        if (ch == '2') return 2;
        if (ch == '3') return 3;
        if (ch == '4') return 4;
        if (ch == '5') return 5;
        if (ch == '6') return 6;
        if (ch == '7') return 7;
        if (ch == '8') return 8;
        if (ch == '9') return 9;
        if (ch == 'a') return 10;
        if (ch == 'A') return 10;
        if (ch == 'B') return 11;
        if (ch == 'b') return 11;
        if (ch == 'C') return 12;
        if (ch == 'c') return 12;
        if (ch == 'D') return 13;
        if (ch == 'd') return 13;
        if (ch == 'E') return 14;
        if (ch == 'e') return 14;
        if (ch == 'F') return 15;
        if (ch == 'f') return 15;
        else return -1;

    }

    public static void main(String[] args) {
        String hex = "7b226964223a2235373236313033343635383238363634353333222c226a736f6e727063223a22e4bda0e5a5bd227d";
        String str = hexToString(hex, "UTF-8");
        System.out.println(str);
        System.out.println(str.length());

    }
}
