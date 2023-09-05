package com.henryxi.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecodeEncodeClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String tobeEncode = "aq/iif25QpMTUi8rg4EuFY3+/YgZQzIYAsa/g+JD8Ck=";
        String afterEncode = URLEncoder.encode(tobeEncode, "UTF-8");
        System.out.println("afterEncode:" + afterEncode);
        String afterDecode = URLDecoder.decode(afterEncode, "UTF-8");
        System.out.println("afterDecode:" + afterDecode);
    }
}
