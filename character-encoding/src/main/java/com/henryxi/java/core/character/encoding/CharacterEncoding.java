package com.henryxi.java.core.character.encoding;

import java.io.UnsupportedEncodingException;

public class CharacterEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String original = "";
        String encoded = new String(original.getBytes("ISO-8859-1"),"UTF-8");
    }
}
