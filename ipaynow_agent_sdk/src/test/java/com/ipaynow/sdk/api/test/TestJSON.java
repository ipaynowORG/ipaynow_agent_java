package com.ipaynow.sdk.api.test;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by ipaynow0407 on 2017/7/7.
 */
class Testj{
    private String testString;

    private String i;
    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }
}
public class TestJSON {
    public static void main(String[] args){
        JSONObject forString = new JSONObject();
        forString.put("testString", "testString");
        forString.put("test", "test");
        Testj t = JSONObject.parseObject(forString.toJSONString(), Testj.class);
        System.out.println(t.getTestString());
    }
}
