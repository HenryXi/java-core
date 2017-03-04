package com.henryxi.java.core.lang;

public class TestString {
    public static void main(String[] args) {
        String origin = "每晚二更视频，发现身边不知道的美（本头条号已经与维权骑士签约）";
        if (origin.contains("（本头条号已经与维权骑士签约）")) {
            System.out.println(origin.replaceAll("（本头条号已经与维权骑士签约）", ""));
        }
    }
}
